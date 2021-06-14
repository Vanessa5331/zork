package io.muic.ssc.zork.monster;

import io.muic.ssc.zork.item.ItemType;

import java.lang.reflect.InvocationTargetException;

public class MonsterFactory {
    public static Monster createMonster(MonsterType monsterType){
        try {
            return monsterType.getMonsterClass().getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            System.out.println("Unknown monster type");
            return null;
        }
    }
}
