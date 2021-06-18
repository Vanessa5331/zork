package io.muic.ssc.zork;

import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.MapFactory;
import io.muic.ssc.zork.map.Room;

public class GameState {
    private Player player;
    private Map map;
    private Room currentRoom;

    public GameState(Game game) {
        this.player = new Player(game.getPlayer());
        this.map = MapFactory.duplicateMap(game.getMap(), game.getCurrentRoom());
        this.currentRoom = this.map.getStartRoom();
    }

    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
