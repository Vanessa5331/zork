package io.muic.ssc.zork.command;

public enum CommandType {
    EXIT("exit", ExitCommand.class, 0, true),
    HELP("help", HelpCommand.class, 0, true);

    private final String commandName;
    private final Class<? extends Command> commandClass;
    private final int numArgs;
    private final boolean midGame;

    CommandType(String commandName, Class<? extends Command> commandClass, int numArgs, boolean midGame){
        this.commandName = commandName;
        this.commandClass = commandClass;
        this.numArgs = numArgs;
        this.midGame = midGame;
    }

    public String getCommandName(){
        return commandName;
    }

    public Class<? extends Command> getCommandClass(){
        return commandClass;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public boolean isAvailableMidGame(){
        return midGame;
    }
}
