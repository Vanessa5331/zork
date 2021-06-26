package io.muic.ssc.zork;

import io.muic.ssc.zork.command.Command;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Scanner in = new Scanner(System.in);
    private final GameOutput output = new GameOutput();
    private final CommandParser commandParser = new CommandParser();
    private final java.util.Map<String, GameState> savedPoints = new HashMap<>();
    private boolean isRunning, isPlaying;
    private Player player;
    private Map map;
    private Room currentRoom;

    public void init(){
        System.out.println("\n\033[0;34m" +
                "▒███████▒ ▒█████   ██▀███   ██ ▄█▀\n" +
                "▒ ▒ ▒ ▄▀░▒██▒  ██▒▓██ ▒ ██▒ ██▄█▒ \n" +
                "░ ▒ ▄▀▒░ ▒██░  ██▒▓██ ░▄█ ▒▓███▄░ \n" +
                "  ▄▀▒   ░▒██   ██░▒██▀▀█▄  ▓██ █▄ \n" +
                "▒███████▒░ ████▓▒░░██▓ ▒██▒▒██▒ █▄\n" +
                "░▒▒ ▓░▒░▒░ ▒░▒░▒░ ░ ▒▓ ░▒▓░▒ ▒▒ ▓▒\n" +
                "░░▒ ▒ ░ ▒  ░ ▒ ▒░   ░▒ ░ ▒░░ ░▒ ▒░\n" +
                "░ ░ ░ ░ ░░ ░ ░ ▒    ░░   ░ ░ ░░ ░ \n" +
                "  ░ ░        ░ ░     ░     ░  ░   \n" +
                "░                                 \n\033[0m");
        System.out.println("\033[1;33m" +
                "----------------------------------------------------\n" +
                "You're invited to the game of Zork\n" +
                "Your goal is to slay the dragon hidden in the map\n" +
                "----------------------------------------------------\n" +
                "Type 'play (default/hard)' to start the game with the selected map\n" +
                "Type 'load [saved-point-name]' to start the game from the saved point\n" +
                "Type 'help' to see all the available commands\n" +
                "----------------------------------------------------\n" +
                "Enjoy!\n" +
                "\033[0m");
        isRunning = true;
    }

    public void start(){
        System.out.print("Enter Your Name\n>>> ");
        String name = in.nextLine();

        player = new Player(name);
        currentRoom.printRoomDescription();
        play();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.print(">>> ");
        String s = in.nextLine();

        if(isPlaying()) {
            if(!player.isAlive()) {
                System.out.printf("Player %s dies\nGAME OVER!", player.getName());
                isPlaying = false;
            }
        }

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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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

    public void load(String name) {
        if (savedPoints.containsKey(name)) {
            GameState savedGame = savedPoints.get(name);
            this.player = savedGame.getPlayer();
            this.map = savedGame.getMap();
            this.currentRoom = savedGame.getCurrentRoom();
            System.out.println("Successfully loaded the saved game");
            player.printStat();
            currentRoom.printRoomDescription();
            play();
        } else {
            System.out.print("Unavailable saved point\n");
        }
    }

    public void save(String name) {
        savedPoints.put(name, new GameState(this));
        System.out.println("Successfully saved the current game");
    }

    public void quit(){
        isPlaying = false;
        System.out.println("\033[1;33m\n" +
                "----------------------------------------------------\n" +
                "Type 'play (default/hard)' to start the game with the selected map\n" +
                "Type 'load [saved-point-name]' to start the game from the saved point\n" +
                "Type 'help' to see all the available commands\n" +
                "----------------------------------------------------\n" +
                "\033[0m");    }

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
