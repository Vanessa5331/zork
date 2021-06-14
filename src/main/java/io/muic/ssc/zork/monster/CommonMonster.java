package io.muic.ssc.zork.monster;

import java.util.Random;

public class CommonMonster implements Monster{
    private static final Random RANDOM = new Random();
    private static final int MAX_HEALTH = 20;
    private int health;
    private boolean alive;

    public CommonMonster() {
        this.health = MAX_HEALTH;
        this.alive = true;
    }

    @Override
    public boolean isAlive(){
        return alive;
    }

    @Override
    public int attack() {
        return RANDOM.nextInt(5);
    }

    @Override
    public void receiveDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }

    @Override
    public void printHealth() {
        System.out.printf("Monster's HP: %d/%d\n", health, MAX_HEALTH);
    }
}
