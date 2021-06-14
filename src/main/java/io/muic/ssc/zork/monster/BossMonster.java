package io.muic.ssc.zork.monster;

import java.util.Random;

public class BossMonster implements Monster{
    private static final Random RANDOM = new Random();
    private static final int MAX_HEALTH = 100;
    private int health;
    private boolean alive;

    public BossMonster() {
        this.health = MAX_HEALTH;
        this.alive = true;
    }

    @Override
    public boolean isAlive(){
        return alive;
    }

    @Override
    public int attack() {
        return RANDOM.nextInt(40);
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
