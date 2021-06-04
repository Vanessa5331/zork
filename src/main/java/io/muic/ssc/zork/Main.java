package io.muic.ssc.zork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.init();

        while(game.isRunning()){
            game.run();
        }
    }
}
