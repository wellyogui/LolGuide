package com.example.wellington.lolguide.view.ui.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.view.ui.details.fragment.HabilidadesFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.LoreFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.OverViewFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.SkinFragment;
import com.example.wellington.lolguide.view.ui.details.fragment.TipsFragment;

import java.io.Serializable;

/**
 * Created by wellington on 21/12/16.
 */
public class MyPageAdapter extends FragmentStatePagerAdapter {
    ChampionDto championDto;

    public MyPageAdapter(FragmentManager fm, ChampionDto mChampionDto) {
        super(fm);
        this.championDto = mChampionDto;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        Bundle bundle = new Bundle();

        switch (position) {
            case 0:
                fragment = new OverViewFragment();
                bundle.putSerializable(OverViewFragment.INFO, this.championDto.info);
                bundle.putSerializable(OverViewFragment.STATS, this.championDto.stats);
                break;
            case 1:
                fragment = new HabilidadesFragment();
                bundle.putSerializable(HabilidadesFragment.HABILIDADE, (Serializable) this.championDto.spells);
                bundle.putSerializable(HabilidadesFragment.PASSIVA, this.championDto.passive);
                break;
            case 2:
                fragment = new LoreFragment();
                bundle.putString(LoreFragment.LORE, this.championDto.lore);
                break;
            case 3:
                fragment = new TipsFragment();
                bundle.putSerializable(TipsFragment.ALLYTIP, (Serializable) this.championDto.allytips);
                bundle.putSerializable(TipsFragment.ENEMYTIP, (Serializable) this.championDto.enemytips);
                break;
            case 4:
                fragment = new SkinFragment();
                bundle.putSerializable(SkinFragment.SKIN, (Serializable) this.championDto.skins);
                break;

            default:
                fragment = new Fragment();
        }

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }
}
