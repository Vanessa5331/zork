package io.muic.ssc.zork.map;

import io.muic.ssc.zork.item.Item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Room {
    private String description;
    private Map<String, Room> possibleExits;
    private Set<Item> itemList;

    public Room(String description) {
        this.description = description;
        possibleExits = new HashMap<>();
        itemList = new HashSet<>();
    }

    public void printRoomDescription() {
        System.out.println("You are " + description);
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

    public void putItem(Item item) {
        itemList.add(item);
    }

    public Item getItem(Item item) {
        if(itemList.contains(item)) {
            return item;
        }
        return null;
    }
}
