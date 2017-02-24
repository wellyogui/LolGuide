package com.example.wellington.lolguide.model;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.champion.ChampionDto;
import com.example.wellington.lolguide.model.item.Item;
import com.example.wellington.lolguide.model.spell.Spell;
import com.example.wellington.lolguide.model.spell.SummonerSpellDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wellington on 20/12/16.
 */

public class ObjectAdapter {

    public static final String ID = "ChampionID";

    public enum ObjectType{
        CHAMPION, SPELL, ITEM
    }

    public String Name;
    public String Id;
    public String Portrait;
    public ObjectType Type;
    public ChampionDto championDto;

    public static List<ObjectAdapter> convertChampionToObject(List<ChampionDto> championList) {

        List<ObjectAdapter> objectAdapters = new ArrayList<>();


        for (ChampionDto champion : championList) {
            ObjectAdapter objectAdapter = new ObjectAdapter();
            objectAdapter.Name = champion.name;
            objectAdapter.Id = String.valueOf(champion.id);
            objectAdapter.Portrait = champion.image.full;
            objectAdapter.Type = ObjectAdapter.ObjectType.CHAMPION;
            objectAdapter.championDto = champion;
            objectAdapters.add(objectAdapter);
        }

        return objectAdapters;
    }

    public static List<ObjectAdapter> convertItemToObjetct(List<Item> itemList){

        List<ObjectAdapter> objectAdapterItem = new ArrayList<>();

        for (Item item : itemList){
            ObjectAdapter objectAdapter = new ObjectAdapter();

            objectAdapter.Name = item.name;
            objectAdapter.Id = String.valueOf(item.id);
            objectAdapter.Portrait = item.image.full;
            objectAdapter.Type = ObjectType.ITEM;

            objectAdapterItem.add(objectAdapter);

        }

        return objectAdapterItem;
    }

        public static List<ObjectAdapter> convertSpellToObject(List<Spell> spellList) {

        List<ObjectAdapter> objectAdaptersSpell = new ArrayList<>();

        for (Spell spell : spellList) {
            if (spell.spellDtoHashMap != null) {

                ObjectAdapter objectAdapter = new ObjectAdapter();
                HashMap<String, SummonerSpellDto> hashMapSpell = spell.spellDtoHashMap;

                Map.Entry<String, SummonerSpellDto> mapEntry = hashMapSpell.entrySet().iterator().next();
                SummonerSpellDto spellDto = mapEntry.getValue();


                objectAdapter.Name = spellDto.name;
                objectAdapter.Id = String.valueOf(spellDto.id);
                objectAdapter.Portrait = spellDto.image.full;
                objectAdapter.Type = ObjectType.SPELL;

                objectAdaptersSpell.add(objectAdapter);


            }


        }
        return objectAdaptersSpell;
    }


}
