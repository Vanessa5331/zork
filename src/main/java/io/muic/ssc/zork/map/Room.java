package io.muic.ssc.zork.map;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private String description;
    private Map<String, Room> possibleExits;
    private Map<String, Item> itemList;

    public Room(String description) {
        this.description = description;
        possibleExits = new HashMap<>();
        itemList = new HashMap<>();
    }

    public void printRoomDescription() {
        System.out.println("You are " + description);
        System.out.print("You see");
        if (itemList.isEmpty()) {
            System.out.println(" nothing useful here");
            return;
        }
        System.out.println();
        for(String itemName: itemList.keySet()) {
            System.out.printf("\t[%s]", itemName);
        }
        System.out.println();
    }

    public void setExits(String direction, Room neighbor) {
        possibleExits.put(direction, neighbor);
    }

    public Set<String> getExits(){
        return possibleExits.keySet();
    }

    public Room exitRoom(String direction) {
        return possibleExits.get(direction);
    }

    public void putItem(String itemName) {
        itemList.put(itemName, ItemFactory.getItem(itemName));
    }

    public Item getItem(String itemName) {
        if(itemList.containsKey(itemName)) {
            return itemList.get(itemName);
        }
        return null;
    }

    public void removeItem(String itemName) {
        itemList.remove(itemName);
    }
}
