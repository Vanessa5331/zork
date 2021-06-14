package io.muic.ssc.zork.command;

public enum CommandType {
    EXIT("exit", ExitCommand.class, 0, true, false),
    HELP("help", HelpCommand.class, 0, true, true),
    INFO("info", InfoCommand.class, 0, false, true),
    PLAY("play", PlayCommand.class, 1, true, false),
    GO("go", GoCommand.class, 1, false, true),
    TAKE("take", TakeCommand.class, 1, false, true),
    DROP("drop", DropCommand.class, 1, false, true),
    EAT("eat", EatCommand.class, 1, false, true),
    LOOK("look", LookCommand.class, 0, false, true),
    QUIT("quit", QuitCommand.class, 0, false, true);

    private final String commandName;
    private final Class<? extends Command> commandClass;
    private final int numArgs;
    private final boolean startGame, midGame;

    CommandType(String commandName, Class<? extends Command> commandClass, int numArgs, boolean startGame, boolean midGame){
        this.commandName = commandName;
        this.commandClass = commandClass;
        this.numArgs = numArgs;
        this.startGame = startGame;
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

    public boolean isAvailableStartGame(){
        return startGame;
    }

    public boolean isAvailableMidGame(){
        return midGame;
    }
}
