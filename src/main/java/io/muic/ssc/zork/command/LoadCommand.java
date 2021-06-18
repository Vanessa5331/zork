package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class LoadCommand implements Command {
    @Override
    public void execute(Game game, List<String> args) {
        String savedName = args.get(0);

        if(savedName.equals("")){
            System.out.println("Please specify the name for the saved point you want to load");
        } else {
            game.load(savedName);
        }
    }
}
