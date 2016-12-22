package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.spell.Spell;

import java.util.List;

/**
 * Created by wellington on 19/12/16.
 */

public interface SpellListListener extends BaseListener{

    void onSpellListLoad(List<Spell> spellList);

}
