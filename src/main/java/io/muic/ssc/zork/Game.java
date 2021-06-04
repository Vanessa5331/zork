package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;

import java.util.List;
import java.util.Scanner;

public class Game {

    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    private boolean isRunning;

    public void init(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Name\n>>> ");
        String name = in.nextLine();

        Player player = new Player(name);

        isRunning = true;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print(">>> ");
        String s = in.nextLine();
        List<String> parsedCommands = commandParser.parse(s);
        Command command = CommandFactory.getCommand(parsedCommands.get(0));
        if(command != null){
            command.execute(this, parsedCommands.subList(1, parsedCommands.size()));
        }else{
            System.out.print("Unavailable command\n");
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void exit(){
        System.exit(0);
        isRunning = false;
    }

    public boolean isRunning(){
        return isRunning;
    }
}
