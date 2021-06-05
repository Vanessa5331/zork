package io.muic.ssc.zork.command;

import io.muic.ssc.zork.CommandFactory;
import io.muic.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        System.out.println("List of Commands:");
        List<String> commands;
        if(game.isPlaying()){
            commands = CommandFactory.getMidCommands();
        }else{
            commands = CommandFactory.getStartCommands();
        }
        for (String command : commands) {
            System.out.println("\t" + command);
        }
    }
}
