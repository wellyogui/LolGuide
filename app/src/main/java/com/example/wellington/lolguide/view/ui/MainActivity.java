package com.example.wellington.lolguide.view.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.github.clans.fab.FloatingActionMenu;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;
    @Bind(R.id.menu)
    FloatingActionMenu fab;

    MyPageAdapterMain mpAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        setTabs();

        fab.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fab.isOpened()) {
                    fab.open(true);
                    fab.getMenuIconView().setImageResource(R.drawable.ic_close);
                } else {
                    fab.close(true);
                    fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
                }
            }
        });


    }

    //region [OnClick]

    @OnClick(R.id.az)
    public void ordenarAZ() {
        ((ChampionFragment) mpAdapter.getItem(0)).reverse();
    }

    @OnClick(R.id.tank)
    public void filterTank() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.TANK);
    }

    @OnClick(R.id.mage)
    public void filterMage() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.MAGE);
    }

    @OnClick(R.id.marskman)
    public void filterMarskman() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.MARKSMAN);
    }

    @OnClick(R.id.support)
    public void filterSupport() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.SUPPORT);
    }

    @OnClick(R.id.fighter)
    public void filterFigher() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.FIGHTER);
    }

    @OnClick(R.id.assassin)
    public void filterAssisn() {
        ((ChampionFragment) mpAdapter.getItem(0)).filter(ChampionEnum.ASSASSIN);
    }

    @OnClick(R.id.remove)
    public void filterRemove() {
        ((ChampionFragment) mpAdapter.getItem(0)).nonFilter();
    }

    //endregion


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    public void callDetails(String id) {

        Intent intent = new Intent(MainActivity.this, ChampionDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(ObjectAdapter.ID, id);

        intent.putExtras(bundle);
        startActivity(intent);

    }


    public void setTabs() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        tabLayout.removeAllTabs();


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.helmet));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.spellbook));
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.shield));


        mpAdapter = new MyPageAdapterMain(fragmentManager);
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
