package com.example.wellington.lolguide.view.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.item.Item;
import com.example.wellington.lolguide.model.spell.Spell;
import com.example.wellington.lolguide.view.ui.details.fragment.HabilidadesFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.LoreFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.OverViewFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.SkinFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.TipsFragment;
import com.example.wellington.lolguide.view.ui.fragment.ChampionFragment;
import com.example.wellington.lolguide.view.ui.fragment.ItemFragment;
import com.example.wellington.lolguide.view.ui.fragment.SpellFragment;

import java.io.Serializable;

/**
 * Created by wellington on 28/12/16.
 */

public class MyPageAdapterMain extends FragmentStatePagerAdapter {



    public MyPageAdapterMain(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                fragment = new ChampionFragment();
                break;
            case 1:
                fragment = new SpellFragment();
                break;
            case 2:
                fragment = new ItemFragment();
                break;

            default:
                fragment = new Fragment();
        }

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
