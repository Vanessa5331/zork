package io.muic.ssc.zork.monster;

public interface Monster {
    boolean isAlive();
    int attack();
    void receiveDamage(int damage);
    void printHealth();
}
