package io.muic.ssc.zork;

public class Player {

    private static final int MAX_HEALTH = 100;
    private static final int MAX_STRENGTH = 100;
    private final String name;
    private int health, strength;

    public Player(String name){
        this.name = name;
        this.health = 50;
        this.strength = 10;

        System.out.printf("Welcome %s !\n", name);
    }

    public void printStat(){
        System.out.printf("Player: %s\n", name);
        System.out.printf("HP: %d/%d\t\tATK: %d/%d\n", health, MAX_HEALTH, strength, MAX_STRENGTH);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void gainEnergy(int energy){
        health += energy;
    }

    public void receiveDamage(int damage){
        health -= damage;
    }

    public void gainPower(int power){
        strength += power;
    }
}
