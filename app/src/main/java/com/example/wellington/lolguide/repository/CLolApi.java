package com.example.wellington.lolguide.repository;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wellington on 19/12/16.
 */

public class CLolApi {

    private static final String SERVER_URL = "https://br.api.pvp.net/";

    LolApi mLolApi;

    public CLolApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        mLolApi = retrofit.create(LolApi.class);
    }

    public LolApi getmLolApi(){
        return mLolApi;
    }

}
