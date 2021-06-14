package io.muic.ssc.zork.map;

import io.muic.ssc.zork.item.Item;
import io.muic.ssc.zork.item.ItemFactory;
import io.muic.ssc.zork.monster.Monster;
import io.muic.ssc.zork.monster.MonsterFactory;
import io.muic.ssc.zork.monster.MonsterType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private String description;
    private Map<String, Room> possibleExits;
    private Map<String, Item> itemList;
    private String monsterName;
    private MonsterType monsterType;
    private Monster monster;

    public Room(String description) {
        this.description = description;
        possibleExits = new HashMap<>();
        itemList = new HashMap<>();
        monster = null;
    }

    public void printRoomDescription() {
        System.out.println("You are " + description);

        System.out.print("You see");
        if (itemList.isEmpty()) {
            System.out.println(" nothing useful here");
        } else {
            System.out.println();
            for (String itemName : itemList.keySet()) {
                System.out.printf("\t[%s]", itemName);
            }
            System.out.println();
        }

        System.out.print("You encounter");
        if (monster == null) {
            System.out.println(" no monster");
        } else {
            System.out.printf(" a %s", monsterName);
            System.out.println();
        }
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

    public void setMonster(MonsterType monsterType) {
        this.monsterName = monsterType.getMonsterName();
        this.monsterType = monsterType;
        this.monster = MonsterFactory.createMonster(monsterType);
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public Monster getMonster() {
        return monster;
    }

    public void removeMonster() {
        this.monster = null;
    }
}
