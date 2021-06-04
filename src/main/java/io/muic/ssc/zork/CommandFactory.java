package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.command.CommandType;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final Map<String, CommandType> COMMAND_MAP = new HashMap<>();

    static {{
        for(CommandType commandType: CommandType.values()){
            COMMAND_MAP.put(commandType.getCommandName(), commandType);
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

    public static List<String> getAllCommands(){
        return new ArrayList<>(COMMAND_MAP.keySet());
    }
}
