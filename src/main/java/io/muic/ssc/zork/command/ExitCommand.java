package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public class ExitCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("Bye!");
        game.exit();
    }
}
