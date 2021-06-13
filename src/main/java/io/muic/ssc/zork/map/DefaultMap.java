package io.muic.ssc.zork.map;

import io.muic.ssc.zork.item.ItemFactory;

public class DefaultMap implements Map{

    public DefaultMap() {
        System.out.println("Creating Default Map\nA friendly map for beginners...");
        create();
    }

    @Override
    public void create() {
        Room outside, dungeon, library, lab, storage, dining, forest;

        outside = new Room("outside the main entrance of the castle");
        dungeon = new Room("in the dungeon");
        library = new Room("in the labyrinth library");
        lab = new Room("in the potion lab");
        storage = new Room("in the storage room");
        dining = new Room("in the dining hall");
        forest = new Room("in the forest");

        outside.setExits("north", library);
        outside.setExits("east", lab);
        outside.setExits("west", dining);
        outside.setExits("south", dungeon);
        outside.putItem(ItemFactory.getItem("sword"));

        dungeon.setExits("north", outside);
        dungeon.setExits("east", storage);

        library.setExits("west", forest);
        library.setExits("south", outside);

        lab.setExits("west", outside);
        lab.setExits("south", storage);

        storage.setExits("north", lab);
        storage.setExits("west", dungeon);
        storage.putItem(ItemFactory.getItem("shield"));

        dining.setExits("north", forest);
        dining.setExits("east", outside);
        dining.putItem(ItemFactory.getItem("bread"));

        forest.setExits("east", library);
        forest.setExits("south", dining);
        forest.putItem(ItemFactory.getItem("apple"));
    }
}
