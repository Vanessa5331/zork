package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class TakeCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String itemName = args.get(0);

        if(itemName.equals("")){
            System.out.println("Please specify the item you want to take");
        } else if(game.getCurrentRoom().getItem(itemName) != null){
            game.getPlayer().gainItem(itemName);
            game.getCurrentRoom().removeItem(itemName);
        } else {
            System.out.println("There's no such item here");
        }
    }
}
