package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.champion.Champion;
import com.example.wellington.lolguide.model.item.Item;
import com.example.wellington.lolguide.model.spell.Spell;

/**
 * Created by wellington on 19/12/16.
 */

public interface ItemListener extends BaseListener{

    void onLoadDetails(Item item);


}
