package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.Player;
import io.muic.ssc.zork.item.ItemFactory;
import io.muic.ssc.zork.item.ItemType;
import io.muic.ssc.zork.map.Room;
import io.muic.ssc.zork.monster.Monster;
import io.muic.ssc.zork.monster.MonsterType;

import java.util.List;

public class AttackCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String itemName = args.get(0);
        ItemType itemType = ItemFactory.getItemType(itemName);
        Monster monster = game.getCurrentRoom().getMonster();
        Player player = game.getPlayer();
        Room currentRoom = game.getCurrentRoom();

        if (monster == null) {
            System.out.println("There's no monster in this room");
        } else if (itemName.equals("")) {
            System.out.println("Please specify your weapon");
        } else if (!itemType.isWeapon()) {
            System.out.println("This item is not a weapon");
        } else {
            for(String ownedItem: player.getInventory()){
                if(itemName.equals(ownedItem)){
                    while (player.isAlive()){
                        int playerAtk = player.attack();
                        int monsterAtk = monster.attack();

                        monster.receiveDamage(playerAtk);
                        System.out.printf("You attack the monster with %s\nMonster loses %d HP\n", itemName, playerAtk);
                        monster.printHealth();
                        if (!monster.isAlive()) {
                            System.out.println("The monster is dead");
                            currentRoom.removeMonster();
                            player.gainPower(5);
                            if (currentRoom.getMonsterType().equals(MonsterType.BOSS)) {
                                System.out.println("CONGRATULATION! YOU DEFEATED THE BOSS!");
                                game.quit();
                            }
                            break;
                        }

                        player.receiveDamage(monsterAtk);
                        System.out.printf("Monster attacks\nYou lose %d HP\n", monsterAtk);
                        player.printHealth();
                    }
                    return;
                }
            }
            System.out.println("There's no such item in your inventory");
        }
    }
}
