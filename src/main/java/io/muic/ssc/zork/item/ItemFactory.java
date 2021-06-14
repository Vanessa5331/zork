package io.muic.ssc.zork.item;

import io.muic.ssc.zork.command.CommandType;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ItemFactory {
    private static final Map<String, ItemType> ITEM_MAP = new HashMap<>();
    private static final Set<String> WEAPON_ITEM = new HashSet<>();
    private static final Set<String> FOOD_ITEM = new HashSet<>();

    static {{
        for(ItemType itemType: ItemType.values()){
            String itemName = itemType.getItemName();
            ITEM_MAP.put(itemName, itemType);
            if(itemType.isFood()){
                FOOD_ITEM.add(itemName);
            }else if(itemType.isWeapon()){
                WEAPON_ITEM.add(itemName);
            }
        }
    }}

    public static Item getItem(String itemName) {
        if(ITEM_MAP.containsKey(itemName)) {
            try {
                return ITEM_MAP.get(itemName).getItemClass().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ItemType getItemType(String itemName){
        return ITEM_MAP.get(itemName);
    }

    public static List<String> getWeapons(){
        return new ArrayList<>(WEAPON_ITEM);
    }

    public static List<String> getFood(){
        return new ArrayList<>(FOOD_ITEM);
    }
}