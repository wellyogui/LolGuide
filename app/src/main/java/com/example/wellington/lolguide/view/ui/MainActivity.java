package com.example.wellington.lolguide.view.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;
    @Bind(R.id.menu)
    FloatingActionMenu fab;

    Context context;

    private InterstitialAd mInterstitialAd;
    private MyPageAdapterMain mpAdapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
        toolbar.setTitleMarginTop(20);

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

    //region [FAB]

    @OnClick(R.id.az)
    public void ordenarAZ() {

        ((ChampionFragment) mpAdapter.getItem(0)).reverse();
        fab.close(true);

    }

    @OnClick(R.id.tank)
    public void filterTank() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.TANK);

        fab.close(true);
    }

    @OnClick(R.id.mage)
    public void filterMage() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MAGE);

        fab.close(true);
    }

    @OnClick(R.id.marskman)
    public void filterMarskman() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MARKSMAN);

        fab.close(true);
    }

    @OnClick(R.id.support)
    public void filterSupport() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.SUPPORT);

        fab.close(true);
    }

    @OnClick(R.id.fighter)
    public void filterFigher() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.FIGHTER);

        fab.close(true);
    }

    @OnClick(R.id.assassin)
    public void filterAssisn() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.ASSASSIN);

        fab.close(true);
    }

    @OnClick(R.id.remove)
    public void filterRemove() {
        ((ChampionFragment) mpAdapter.getItem(0)).nonFilter();

        ((ChampionFragment) mpAdapter.getItem(0)).cleanChampFilter();

        fab.close(true);


    }

    @OnClick(R.id.freeToPlay)
    public void filterFree() {

        ((ChampionFragment) mpAdapter.getItem(0)).freeWeek();

        fab.close(true);
    }

    //endregion

    //region [SearchView]

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_header, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        int searchImgId = android.support.v7.appcompat.R.id.search_button;
        ImageView v = (ImageView) searchView.findViewById(searchImgId);
        v.setImageResource(R.drawable.bt_search);

        int searchCloseImgId = android.support.v7.appcompat.R.id.search_close_btn;
        ImageView vClose = (ImageView) searchView.findViewById(searchCloseImgId);
        vClose.setImageResource(R.drawable.bt_close);


        searchView.setQueryHint("Buscar");
        searchView.setOnQueryTextListener(this);

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchMenu();
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                closeSearchMenu();
                ((ChampionFragment) mpAdapter.getItem(0)).resetChampionList();
                return false;
            }
        });

        return true;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        if (query.length() > 0) {
            ((ChampionFragment) mpAdapter.getItem(0)).filterName(query);
        } else {
            ((ChampionFragment) mpAdapter.getItem(0)).resetChampionList();
        }

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }

    //endregion

    private void openSearchMenu() {
        fab.setVisibility(View.GONE);

    }

    public void closeSearchMenu() {
        fab.setVisibility(View.VISIBLE);
    }


    public void callDetails(String id, ActivityOptionsCompat activityOptionsCompat) {

        Intent intent = new Intent(MainActivity.this, ChampionDetail.class);

        Bundle bundle = new Bundle();
        bundle.putString(ObjectAdapter.ID, id);

        intent.putExtras(bundle);
        startActivity(intent, activityOptionsCompat.toBundle());

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
