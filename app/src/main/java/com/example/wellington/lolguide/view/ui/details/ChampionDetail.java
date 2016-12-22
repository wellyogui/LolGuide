package com.example.wellington.lolguide.view.ui.details;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.presenter.ChampionPresenter;
import com.example.wellington.lolguide.repository.contracts.ChampionDetailListener;
import com.example.wellington.lolguide.utils.AppConfigs;
import com.example.wellington.lolguide.view.adapter.MainAdapter;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChampionDetail extends AppCompatActivity {

    private Context mContext;
    private ChampionDto championdto;
    private ChampionPresenter championPresenter;

    private String region = "br";


    @Bind(R.id.ivPortrait)
    ImageView ivPortrait;
    @Bind(R.id.tvNameChampion)
    TextView tvNameChampion;
    @Bind(R.id.tvTitleChampion)
    TextView tvTitleChampion;
    @Bind(R.id.sliding_tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_detail);
        ButterKnife.bind(this);


        getDetails();


    }

    public void getDetails(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String id = bundle.getString(ObjectAdapter.ID);
            championPresenter = new ChampionPresenter();

            championPresenter.loadChampionDetails(region, id, "all", AppConfigs.api_key, new ChampionDetailListener() {
                @Override
                public void onChampionDetail(ChampionDto championDto) {
                    setChampionDetails(championDto);
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

    public void setChampionDetails(ChampionDto championDto){

        setTabs(championDto);

        tvNameChampion.setText(championDto.name);
        tvTitleChampion.setText(championDto.title);

        Picasso.with(mContext).load(String.format(AppConfigs.portraitChampion, championDto.image.full)).into(ivPortrait);


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
