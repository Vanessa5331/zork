package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.map.Room;

import java.util.List;

public class GoCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String direction = args.get(0);
        Room nextRoom = game.getCurrentRoom().exitRoom(direction);

        if(nextRoom != null){
            game.setCurrentRoom(nextRoom);
            game.getPlayer().gainEnergy(5);
            nextRoom.printRoomDescription();
        } else {
            System.out.println("You try to walk away but you're still in the same place...");
        }
    }
}
