package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class DropCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String itemName = args.get(0);

        if(!itemName.equals("")){
            for(String ownedItem: game.getPlayer().getInventory()){
                if(itemName.equals(ownedItem)){
                    game.getPlayer().dropItem(itemName);
                    game.getCurrentRoom().putItem(itemName);
                    return;
                }
            }
            System.out.println("There's no such item in your inventory");
            return;
        }
        System.out.println("Please specify the item you want to drop");
    }
}
