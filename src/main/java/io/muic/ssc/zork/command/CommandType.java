package io.muic.ssc.zork.command;

public enum CommandType {
    EXIT("exit", ExitCommand.class);

    private final String commandType;
    private final Class<? extends Command> commandClass;

    CommandType(String commandType, Class<? extends Command> commandClass){
        this.commandType = commandType;
        this.commandClass = commandClass;
    }

    public String getCommandType(){
        return commandType;
    }

    public Class<? extends Command> getCommandClass(){
        return commandClass;
    }
}
