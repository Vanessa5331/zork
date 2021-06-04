package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.command.CommandType;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final Map<String, CommandType> COMMAND_MAP = new HashMap<>();
    private static final Set<String> START_COMMAND = new HashSet<>();
    private static final Set<String> MID_COMMAND = new HashSet<>();

    static {{
        for(CommandType commandType: CommandType.values()){
            String commandName = commandType.getCommandName();
            COMMAND_MAP.put(commandName, commandType);
            if(commandType.isAvailableStartGame()){
                START_COMMAND.add(commandName);
            }
            if(commandType.isAvailableMidGame()){
                MID_COMMAND.add(commandName);
            }
        }
    }}

    public static Command getCommand(String commandName){
        try{
            return COMMAND_MAP.get(commandName).getCommandClass().getConstructor().newInstance();
        } catch (NullPointerException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            return null;
        }
    }

    public static CommandType getCommandType(String commandName){
        return COMMAND_MAP.get(commandName);
    }

    public static List<String> getStartCommands(){
        return new ArrayList<>(START_COMMAND);
    }

    public static List<String> getMidCommands(){
        return new ArrayList<>(MID_COMMAND);
    }
}
