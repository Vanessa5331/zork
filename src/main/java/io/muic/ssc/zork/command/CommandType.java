package io.muic.ssc.zork.command;

public enum CommandType {
    EXIT("exit", ExitCommand.class);

    private final String commandName;
    private final Class<? extends Command> commandClass;

    CommandType(String commandName, Class<? extends Command> commandClass){
        this.commandName = commandName;
        this.commandClass = commandClass;
    }

    public String getCommandName(){
        return commandName;
    }

    public Class<? extends Command> getCommandClass(){
        return commandClass;
    }
}
