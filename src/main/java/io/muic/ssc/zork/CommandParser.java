package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CommandParser {

    private String matchInputToCommand(String input, boolean isRunning){
        List<String> commands;
        if(!isRunning){
            commands = CommandFactory.getStartCommands();
        }else{
            commands = CommandFactory.getMidCommands();
        }
        for(String command: commands){
            if(input.startsWith(command)){
                return command;
            }
        }
        return null;
    }

    public List<String> parse(String input, boolean isRunning){
        String cleanedInput = input.trim();
        String inputToCommand = matchInputToCommand(cleanedInput, isRunning);
        if(inputToCommand != null) {
            String argString = cleanedInput.substring(inputToCommand.length()).trim();
            return Arrays.asList(inputToCommand, argString);
        }else{
            return Arrays.asList(inputToCommand);
        }
    }
}
