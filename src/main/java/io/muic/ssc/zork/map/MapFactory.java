package io.muic.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;

public class MapFactory {
    public static void createMap(MapType mapType) {
        try {
            mapType.getMapClass().getConstructor().newInstance();
            System.out.println("The map is succesfully created");
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("Failed to create map");
        }
    }
}
