package com.example.wellington.lolguide.view.ui.details;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.champion.Skin;
import com.example.wellington.lolguide.presenter.ChampionPresenter;
import com.example.wellington.lolguide.repository.contracts.ChampionDetailListener;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.example.wellington.lolguide.view.ui.NoConnection;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.ldoublem.loadingviewlib.view.LVCircularRing;
import com.squareup.picasso.Picasso;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.wellington.lolguide.view.ui.fragment.ChampionFragment.RESULT_NO_CONNECTION;

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
    @Bind(R.id.llLoading)
    RelativeLayout llLoading;
    @Bind(R.id.lv_circularring)
    LVCircularRing lvCircularRing;
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


    InterstitialAd mInterstitialAd;
    private static final String LOG_TAG = "InterstitialSample";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_detail);
        ButterKnife.bind(this);

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FrizQuadrata.ttf");
        tvNameChampion.setTypeface(type);
        tvTag.setTypeface(type);
        tvTitleChampion.setTypeface(type);
        tvTag.setTypeface(type);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("");

            Drawable drawable = toolbar.getNavigationIcon();
            drawable.setColorFilter(ContextCompat.getColor(this, R.color.whiteFont), PorterDuff.Mode.SRC_ATOP);
        }


        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this)
                .inflateTransition(R.transition.transition));



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.idIntersticialAd));

        MobileAds.initialize(this, String.valueOf(R.string.idIntersticialAd));

        requestNewInterstitial();

        randomAd();

//        setSwipe();

//        setDetails();


    }



    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .tagForChildDirectedTreatment(true)
                .build();

        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.show();
    }

    private void randomAd(){
        Random random = new Random();
        int i = random.nextInt(10);

        if (i <= 3){
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(int i) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAdLoaded() {
                    Log.d(LOG_TAG, "onAdLoaded");
                    mInterstitialAd.show();
                }

                @Override
                public void onAdOpened() {
                    setDetails();
                }

                @Override
                public void onAdClosed() {

                }
            });
        } else {
            setDetails();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            supportFinishAfterTransition();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("DefaultLocale")
    public void setSkins(ChampionDto championDto) {
        final List<Skin> skin = championDto.skins;

        if (skin != null && skin.size() > 0) {
            Random random = new Random();
            final int n = random.nextInt(skin.size());

            String[] arrayString = championDto.image.full.split("\\.");


            Picasso.with(this).load(String.format(AppConfigs.skinsImage, arrayString[0], skin.get(n).num)).placeholder(R.drawable.bg_detail).into(bgDetails);


        }

    }

//    private void setSwipe() {
//        View myView = findViewById(R.id.llPrincipal);
//        myView.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                int action = MotionEventCompat.getActionMasked(event);
//                switch (action) {
//                    case (MotionEvent.ACTION_DOWN):
//                        onBackPressed();
//                        return true;
//                    default:
//                        return true;
//                }
//            }
//        });
//    }


    public void setDetails() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

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
                    startLoadingScreen();
                }

                @Override
                public void onRequestFinished() {
                    dismissLoadingScreen();
                }

                @Override
                public void onError(Throwable error) {
                    Intent intent = new Intent(getBaseContext().getApplicationContext(), NoConnection.class);
                    startActivityForResult(intent, RESULT_NO_CONNECTION);

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

        tabLayout.addTab(tabLayout.newTab().setText("Detalhes"));
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

    private void startLoadingScreen() {
        llLoading.setVisibility(View.VISIBLE);
        lvCircularRing.setViewColor(Color.argb(100, 255, 255, 255));
        lvCircularRing.setBarColor(Color.YELLOW);
        lvCircularRing.startAnim();
    }

    private void dismissLoadingScreen() {
        llLoading.setVisibility(View.GONE);
    }

}
