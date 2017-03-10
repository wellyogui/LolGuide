package com.example.wellington.lolguide.view.ui.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Skin;
import com.example.wellington.lolguide.presenter.ChampionPresenter;
import com.example.wellington.lolguide.repository.contracts.ChampionDetailListener;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChampionDetail extends AppCompatActivity {

    private Context mContext;
    private ChampionPresenter championPresenter;


    private String region = "br";

    //region [Bind Principal Info]
    @Bind(R.id.ivPortrait)
    ImageView ivPortrait;
    @Bind(R.id.ivBorderProtraitDetail)
    ImageView ivBorder;
    @Bind(R.id.tvNameChampion)
    TextView tvNameChampion;
    @Bind(R.id.tvTitleChampion)
    TextView tvTitleChampion;
    @Bind(R.id.llPrincipal)
    LinearLayout linearLayoutPrincipal;
    @Bind(R.id.ivBgDetails)
    ImageView bgDetails;
    @Bind(R.id.toolbarBack)
    Toolbar toolbar;
    //endregion

    //region [Bind Tags]
    @Bind(R.id.tvTag)
    TextView tvTag;
    //endregion

    //region [Bind TabLayout]
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_detail);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");

            Drawable drawable = toolbar.getNavigationIcon();
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.whiteFont), PorterDuff.Mode.SRC_ATOP);
        }


        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this)
                .inflateTransition(R.transition.transition));


        setDetails();

//        setSwipe();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            super.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("DefaultLocale")
    public void setSkins(ChampionDto championDto) {
        final List<Skin> skin = championDto.skins;

        if (skin != null && skin.size() > 0) {
            Random random = new Random();
            final int n = random.nextInt(skin.size());


            Picasso.with(this).load(String.format(AppConfigs.skinsImage, championDto.name, skin.get(n).num)).placeholder(R.drawable.bg_detail).into(bgDetails);


        }

    }

    private void setSwipe() {
        View myView = findViewById(R.id.llPrincipal);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int action = MotionEventCompat.getActionMasked(event);
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        onBackPressed();
                        return true;
                    default:
                        return true;
                }
            }
        });
    }


    public void setDetails() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String id = bundle.getString(ObjectAdapter.ID);
            championPresenter = new ChampionPresenter();

            championPresenter.loadChampionDetails(region, id, "all", AppConfigs.api_key, new ChampionDetailListener() {
                @Override
                public void onChampionDetail(ChampionDto championDto) {
                    setChampionDetails(championDto);

                    setSkins(championDto);
                }

                @Override
                public void onRequestStarted() {

                }

                @Override
                public void onRequestFinished() {

                }

                @Override
                public void onError(Throwable error) {

                }
            });

        }

    }

    public void setChampionDetails(ChampionDto championDto) {

        setTabs(championDto);

        tvNameChampion.setText(championDto.name);
        tvTitleChampion.setText(championDto.title);

        setTag(championDto.tags);

        Picasso.with(mContext).load(String.format(AppConfigs.portraitChampion, championDto.image.full)).into(ivPortrait);


    }

    private void setTag(List<String> tagList) {


        String mTag = "";

        for (String tag : tagList) {

            mTag += tag + "/";


        }

        mTag = mTag.substring(0, mTag.length() - 1);

        tvTag.setText(mTag);

    }


    public void setTabs(ChampionDto championdto) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setText("OverView"));
        tabLayout.addTab(tabLayout.newTab().setText("Habilidades"));
        tabLayout.addTab(tabLayout.newTab().setText("Lore"));
        tabLayout.addTab(tabLayout.newTab().setText("Dicas"));
        tabLayout.addTab(tabLayout.newTab().setText("Skins"));

        MyPageAdapter mpAdapter = new MyPageAdapter(fragmentManager, championdto);
        viewPager.setAdapter(mpAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(tabLayout.getTabCount());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}
