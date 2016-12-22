package com.example.wellington.lolguide.presenter;

import com.example.wellington.lolguide.model.item.Item;
import com.example.wellington.lolguide.repository.CLolApi;
import com.example.wellington.lolguide.repository.contracts.ItemListListener;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wellington on 19/12/16.
 */

public class ItemPresenter {

    private CLolApi lolApi;

    public ItemPresenter(){
        lolApi = new CLolApi();
    }

    public void loadItemList(String region, String champData, String key, final ItemListListener listener) {
        listener.onRequestStarted();

        lolApi.getmLolApi()
                .getItemList(region, champData, key)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Item>>() {
                    @Override
                    public void onCompleted() {
                        listener.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onRequestFinished();
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(List<Item> item) {
                        listener.onItemListLoad(item);
                    }
                });



    }
}
