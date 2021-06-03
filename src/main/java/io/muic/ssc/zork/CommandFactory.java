package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.command.CommandType;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CommandFactory {

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();

    static {{
        for(CommandType commandType: CommandType.values()){
            try {
                Command command = commandType.getCommandClass().getConstructor().newInstance();
                COMMAND_MAP.put(commandType.getCommandName(), command);
            } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }}

    public static Command get(String command){
        return COMMAND_MAP.get(command);
    }

    public static List<String> getAllCommands(){
        return new ArrayList<>(COMMAND_MAP.keySet());
    }
}
