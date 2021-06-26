package io.muic.ssc.zork.map;

import io.muic.ssc.zork.monster.MonsterType;

import java.util.HashSet;
import java.util.Set;

public class HardMap implements Map{
    private Set<Room> roomSet;
    private Room outside, dungeon, library, lab, storage, dining, forest, armory, forbidden;
    private Room startRoom;

    public HardMap() {
        System.out.println("Hard Map\nA challenging map for those who dare...");
        this.roomSet = new HashSet<>();
        create();
        setAllExits();
    }

    public HardMap(HardMap map, Room currentRoom) {
        this.roomSet = new HashSet<>();
        duplicate(map);
        for(Room room: this.roomSet) {
            if(room.getDescription().equals(currentRoom.getDescription())) {
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
        armory = new Room("in the armory");
        forbidden = new Room("in the forbidden room");

        armory.putItem("sword");
        armory.putItem("shield");
        dining.putItem("bread");
        outside.putItem("apple");

        forest.setMonster(MonsterType.BOSS);
        dungeon.setMonster(MonsterType.COMMON);
        lab.setMonster(MonsterType.COMMON);
        forbidden.setMonster(MonsterType.COMMON);

        startRoom = outside;

        addAllRooms();
    }

    public void duplicate(HardMap map){
        this.outside = new Room(map.outside);
        this.dungeon = new Room(map.dungeon);
        this.library = new Room(map.library);
        this.lab = new Room(map.lab);
        this.storage = new Room(map.storage);
        this.dining = new Room(map.dining);
        this.forest = new Room(map.forest);
        this.armory = new Room(map.armory);
        this.forbidden = new Room(map.forbidden);

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
        roomSet.add(armory);
        roomSet.add(forbidden);
    }

    public void setAllExits() {
        outside.setExits("east", library);

        dungeon.setExits("north", armory);
        dungeon.setExits("south", forbidden);

        library.setExits("east", lab);
        library.setExits("west", outside);
        library.setExits("south", dining);

        lab.setExits("east", armory);
        lab.setExits("west", library);
        lab.setExits("south", storage);

        storage.setExits("north", lab);
        storage.setExits("west", dining);

        dining.setExits("north", library);
        dining.setExits("east", storage);

        forest.setExits("west", forbidden);

        armory.setExits("west", lab);
        armory.setExits("south", dungeon);

        forbidden.setExits("north", dungeon);
        forbidden.setExits("east", forest);
    }

    @Override
    public Room getStartRoom(){
        return startRoom;
    }
}
