package io.muic.ssc.zork.map;

import io.muic.ssc.zork.monster.MonsterType;

import java.util.HashSet;
import java.util.Set;

public class DefaultMap implements Map{
    private Set<Room> roomSet;
    private Room outside, dungeon, library, lab, storage, dining, forest;
    private Room startRoom;

    public DefaultMap() {
        System.out.println("Default Map\nA friendly map for beginners...");
        this.roomSet = new HashSet<>();
        create();
        setAllExits();
    }

    public DefaultMap(DefaultMap map, Room currentRoom) {
        this.roomSet = new HashSet<>();
        duplicate(map);
        for(Room room: this.roomSet) {
            if(room.getDescription().equals(currentRoom.getDescription())) {
                System.out.println("found room");
                this.startRoom = room;
            }
        }
        setAllExits();
    }

    @Override
    public void create() {
        outside = new Room("outside the main entrance of the castle");
        dungeon = new Room("in the dungeon");
        library = new Room("in the labyrinth library");
        lab = new Room("in the potion lab");
        storage = new Room("in the storage room");
        dining = new Room("in the dining hall");
        forest = new Room("in the forest");

        outside.putItem("sword");
        storage.putItem("shield");
        dining.putItem("bread");
        forest.putItem("apple");

        dungeon.setMonster(MonsterType.BOSS);
        lab.setMonster(MonsterType.COMMON);

        startRoom = outside;

        addAllRooms();
    }

    public void duplicate(DefaultMap map){
        this.outside = new Room(map.outside);
        this.dungeon = new Room(map.dungeon);
        this.library = new Room(map.library);
        this.lab = new Room(map.lab);
        this.storage = new Room(map.storage);
        this.dining = new Room(map.dining);
        this.forest = new Room(map.forest);

        this.startRoom = outside;

        addAllRooms();
    }

    public void addAllRooms() {
        roomSet.add(outside);
        roomSet.add(dungeon);
        roomSet.add(library);
        roomSet.add(lab);
        roomSet.add(storage);
        roomSet.add(dining);
        roomSet.add(forest);
    }

    public void setAllExits() {
        outside.setExits("north", library);
        outside.setExits("east", lab);
        outside.setExits("west", dining);
        outside.setExits("south", dungeon);

        dungeon.setExits("north", outside);
        dungeon.setExits("east", storage);

        library.setExits("west", forest);
        library.setExits("south", outside);

        lab.setExits("west", outside);
        lab.setExits("south", storage);

        storage.setExits("north", lab);
        storage.setExits("west", dungeon);

        dining.setExits("north", forest);
        dining.setExits("east", outside);

        forest.setExits("east", library);
        forest.setExits("south", dining);
    }

    @Override
    public Room getStartRoom(){
        return startRoom;
    }
}
