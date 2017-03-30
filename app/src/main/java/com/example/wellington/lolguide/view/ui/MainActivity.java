package com.example.wellington.lolguide.view.ui;

import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wellington.lolguide.R;
import com.example.wellington.lolguide.model.ChampionEnum;
import com.example.wellington.lolguide.model.ObjectAdapter;
import com.example.wellington.lolguide.view.ui.details.ChampionDetail;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.sliding_tabs_main)
    TabLayout tabLayout;
    @Bind(R.id.viewpager_main)
    ViewPager viewPager;
    @Bind(R.id.menu)
    FloatingActionMenu fab;
    @Bind(R.id.viewClickable)
    View viewClickable;


    private MyPageAdapterMain mpAdapter;
    private SearchView searchView;
    private AdView mAdView;


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

        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/FrizQuadrata.ttf");

        fab.setOnMenuButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fab.isOpened()) {
                    fab.open(true);
                    fab.getMenuIconView().setImageResource(R.mipmap.ic_close);
                    viewClickable.setVisibility(View.VISIBLE);

                } else {
                    fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
                    viewClickable.setVisibility(GONE);
                    fab.close(true);

                }
            }
        });

        mAdView = (AdView) findViewById(R.id.adViewSkin);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @OnClick(R.id.viewClickable)
    public void viewClick() {

    }


    //region [FAB]

    @OnClick(R.id.az)
    public void ordenarAZ() {

        ((ChampionFragment) mpAdapter.getItem(0)).reverse();
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);
        fab.close(true);


    }

    @OnClick(R.id.tank)
    public void filterTank() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.TANK);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.mage)
    public void filterMage() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MAGE);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.marskman)
    public void filterMarskman() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.MARKSMAN);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.support)
    public void filterSupport() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.SUPPORT);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.fighter)
    public void filterFigher() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.FIGHTER);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.assassin)
    public void filterAssisn() {
        ((ChampionFragment) mpAdapter.getItem(0)).filterChamp(ChampionEnum.ASSASSIN);
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);
    }

    @OnClick(R.id.remove)
    public void filterRemove() {
        ((ChampionFragment) mpAdapter.getItem(0)).nonFilter();

        ((ChampionFragment) mpAdapter.getItem(0)).cleanChampFilter();
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

        fab.close(true);


    }

    @OnClick(R.id.freeToPlay)
    public void filterFree() {

        ((ChampionFragment) mpAdapter.getItem(0)).freeWeek();
        fab.getMenuIconView().setImageResource(R.drawable.ic_menu);
        viewClickable.setVisibility(GONE);

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

        EditText editText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        editText.setTextColor(getResources().getColor(R.color.darkBlack));
        editText.setBackgroundColor(getResources().getColor(R.color.white));

        searchView.setQueryHint(getResources().getString(R.string.hintSearchMess));

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

    private void openSearchMenu() {
        fab.setVisibility(GONE);
        ((ChampionFragment) mpAdapter.getItem(0)).hideLogo();
        mAdView.setVisibility(GONE);
    }

    public void closeSearchMenu() {
        fab.setVisibility(View.VISIBLE);

        ((ChampionFragment) mpAdapter.getItem(0)).showLogo();
        mAdView.setVisibility(View.VISIBLE);
    }

    //endregion


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
