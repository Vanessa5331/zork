package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class LookCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        game.getCurrentRoom().printRoomDescription();
        System.out.println("You can go ");
        for(String direction: game.getCurrentRoom().getExits()) {
            System.out.printf("\t[%s]", direction);
        }
        System.out.println();
    }
}
