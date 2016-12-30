package com.example.wellington.lolguide.view.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.FrameLayout;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.details.MyPageAdapter;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        setTabs();


    }

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
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.spellbook));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.shield));


        MyPageAdapterMain mpAdapter = new MyPageAdapterMain(fragmentManager);
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
