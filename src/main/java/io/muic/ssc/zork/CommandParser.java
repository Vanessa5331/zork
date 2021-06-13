package io.muic.ssc.zork;

import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private String matchInputToCommand(String input, boolean isPlaying){
        List<String> commands;
        if(!isPlaying){
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

    public List<String> parse(String input, boolean isPlaying){
        String cleanedInput = input.trim();
        String inputToCommand = matchInputToCommand(cleanedInput, isPlaying);
        if(inputToCommand != null) {
            String argString = cleanedInput.substring(inputToCommand.length()).trim();
            int argLen = argString.split(" ").length;
            int numArg = CommandFactory.getCommandType(inputToCommand).getNumArgs();
            if(numArg == 0 || argLen == numArg){
                return Arrays.asList(inputToCommand, argString);
            }
        }
        return Arrays.asList(null, "");
    }
}
