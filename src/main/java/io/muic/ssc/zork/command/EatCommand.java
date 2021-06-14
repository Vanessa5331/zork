package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.item.ItemFactory;
import io.muic.ssc.zork.item.ItemType;

import java.util.List;

public class EatCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String itemName = args.get(0);
        ItemType itemType = ItemFactory.getItemType(itemName);

        if(itemName.equals("")){
            System.out.println("Please specify the item you want to eat");
        } else if(!itemType.isFood()) {
            System.out.println("This item is inedible");
        } else {
            for(String ownedItem: game.getPlayer().getInventory()) {
                if(itemName.equals(ownedItem)) {
                    game.getPlayer().dropItem(itemName);
                    game.getPlayer().gainEnergy(itemType.getHealth());
                    return;
                }
            }
            System.out.println("There's no such item in your inventory");
        }
    }
}
