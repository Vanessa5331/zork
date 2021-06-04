package io.muic.ssc.zork.command;

public enum CommandType {
    EXIT("exit", ExitCommand.class, true),
    HELP("help", HelpCommand.class, true);

    private final String commandName;
    private final Class<? extends Command> commandClass;
    private final boolean midGame;

    CommandType(String commandName, Class<? extends Command> commandClass, boolean midGame){
        this.commandName = commandName;
        this.commandClass = commandClass;
        this.midGame = midGame;
    }

    public String getCommandName(){
        return commandName;
    }

    public Class<? extends Command> getCommandClass(){
        return commandClass;
    }

    public boolean isAvailableMidGame(){
        return midGame;
    }
}
