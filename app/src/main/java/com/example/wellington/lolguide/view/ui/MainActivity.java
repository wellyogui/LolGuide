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
import android.widget.Toast;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.github.clans.fab.FloatingActionMenu;

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
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.TANK);
    }

    @OnClick(R.id.mage)
    public void filterMage() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MAGE);
    }

    @OnClick(R.id.marskman)
    public void filterMarskman() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MARKSMAN);
    }

    @OnClick(R.id.support)
    public void filterSupport() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.SUPPORT);
    }

    @OnClick(R.id.fighter)
    public void filterFigher() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.FIGHTER);
    }

    @OnClick(R.id.assassin)
    public void filterAssisn() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.ASSASSIN);
    }

    @OnClick(R.id.remove)
    public void filterRemove() {
        ((ChampionFragment) mpAdapter.getItem(0)).nonFilter();

        ((ChampionFragment) mpAdapter.getItem(0)).cleanChampFilter();


    }

    //endregion

    //region [SearchView]

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_header, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();


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

        if(query.length() > 0){
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
