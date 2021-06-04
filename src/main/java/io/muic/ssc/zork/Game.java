package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;

import javax.security.auth.login.AccountLockedException;
import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();

    public void run() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> parsedCommands = commandParser.parse(s);
        Command command = CommandFactory.getCommand(parsedCommands.get(0));
        if(command != null){
            command.execute(this, parsedCommands.subList(1, parsedCommands.size()));
        }else{
            System.out.println("Unavailable command");
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit(){
        System.exit(0);
    }
}
