package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.map.Room;

import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner in = new Scanner(System.in);
    private final GameOutput output = new GameOutput();
    private final CommandParser commandParser = new CommandParser();
    private boolean isRunning, isPlaying;
    private Player player;
    private Room currentRoom;

    public void init(){
        isRunning = true;
        //TODO: let the player choose map or load game
        start();
    }

    public void start(){
        System.out.print("Enter Your Name\n>>> ");
        String name = in.nextLine();

        player = new Player(name);

    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print(">>> ");
        String s = in.nextLine();
        List<String> parsedCommands = commandParser.parse(s, isPlaying);
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

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public void play(){
        isPlaying = true;
    }

    public void quit(){
        isPlaying = false;
    }

    public void exit(){
        System.exit(0);
        in.close();
        isRunning = false;
    }

    public boolean isRunning(){
        return isRunning;
    }

    public boolean isPlaying(){
        return isPlaying;
    }
}
