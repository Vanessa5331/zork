package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;

import java.util.List;

public interface Command {

    int numArgs();

    void execute(Game game, List<String> args);
}
