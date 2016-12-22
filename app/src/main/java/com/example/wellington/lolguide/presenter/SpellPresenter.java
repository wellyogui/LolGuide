package com.example.wellington.lolguide.presenter;

import com.example.wellington.lolguide.model.spell.Spell;
import com.example.wellington.lolguide.repository.CLolApi;
import com.example.wellington.lolguide.repository.contracts.SpellListListener;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wellington on 19/12/16.
 */

public class SpellPresenter {

    private CLolApi lolApi;

    public SpellPresenter() {
        lolApi = new CLolApi();
    }

//    public void loadItemList(String region, String champData, String key, final SpellListListener listener) {
//        listener.onRequestStarted();
//
//        lolApi.getmLolApi()
//                .getSpellList(region, champData, key)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<List<Item>>() {
//                    @Override
//                    public void onCompleted() {
//                        listener.onRequestFinished();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        listener.onRequestFinished();
//                        listener.onError(e);
//                    }
//
//                    @Override
//                    public void onNext(List<Spell> spell) {
//                        listener.onSpellListLoad(spell);
//                    }
//                });
//
//
//    }
}
