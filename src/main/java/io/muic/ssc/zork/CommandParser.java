package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();
    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandsSortedByLength.sort(Comparator.comparingInt(String::length));
    }

    private String matchInputToCommand(String input){
        for(String command: allCommandsSortedByLength){
            if(input.startsWith(command)){
                return command;
            }
        }
        return null;
    }

    public List<String> parse(String input){
        String cleanedInput = input.trim();
        String inputToCommand = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(inputToCommand);
        if(command != null && command.numArgs() > 0){
            String argString = cleanedInput.substring(inputToCommand.length());
            return Arrays.asList(inputToCommand, argString);
        }else{
            return Arrays.asList(inputToCommand);
        }
    }
}
