package com.example.wellington.lolguide.repository;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.item.Item;
import com.example.wellington.lolguide.model.spell.Spell;
import com.example.wellington.lolguide.model.spell.SummonerSpellDto;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wellington on 19/12/16.
 */

public interface LolApi {

    //    champData=image,info&api_key=RGAPI-c9d93c41-f833-4f9f-89aa-7dfbf94d9b6a


    @GET("/api/lol/static-data/{region}/v1.2/champion/{id}")
    Observable<ChampionDto> getChampion(@Path("region") String region,
                                     @Path("id") String id,
                                     @Query("champData") String champData,
                                     @Query("api_key") String key);

//    @GET("/api/lol/{region}/v1.2/champion")
//      Observable<Champion> getFreeRoation


    @GET("/api/lol/static-data/{region}/v1.2/champion/")
    Observable<Champion> getChampionList(@Path("region") String region,
                                            @Query("champData") String champData,
                                            @Query("api_key") String key);

    @GET("/api/lol/static-data/{region}/v1.2/item/{id}")
    Observable<Item> getItem(@Path("region") String region,
                             @Path("id") String id,
                             @Query("itemData") String itemData,
                             @Query("api_key") String key);

    @GET("/api/lol/static-data/{region}/v1.2/item/")
    Observable<List<Item>> getItemList(@Path("region") String region,
                             @Query("itemData") String itemData,
                             @Query("api_key") String key);

    @GET("/api/lol/static-data/{region}/v1.2/summoner-spell/{id}")
    Observable<Spell> getSpell(@Path("region") String region,
                               @Path("id") String id,
                               @Query("spellData") String spellData,
                                @Query("api_key") String key);


    @GET("/api/lol/static-data/{region}/v1.2/summoner-spell/")
    Observable<SummonerSpellDto> getSpellList(@Path("region") String region,
                                              @Query("spellData") String spellData,
                                              @Query("api_key") String key);

}
