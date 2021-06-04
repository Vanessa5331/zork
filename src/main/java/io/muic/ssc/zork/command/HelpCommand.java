package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        System.out.println("List of Commands:");
        for(CommandType commandType: CommandType.values()){
            System.out.println("\t" + commandType.getCommandName());
        }
    }
}
