package io.muic.ssc.zork;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Name: ");
        String name = in.nextLine();

        Player player = new Player(name);

        game.run();
    }
}
