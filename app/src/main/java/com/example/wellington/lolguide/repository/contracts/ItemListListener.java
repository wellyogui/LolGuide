package com.example.wellington.lolguide.repository.contracts;

import com.example.wellington.lolguide.model.item.Item;

import java.sql.Array;
import java.util.List;

/**
 * Created by wellington on 19/12/16.
 */

public interface ItemListListener extends BaseListener {

    void onItemListLoad(List<Item> itemList);


}
