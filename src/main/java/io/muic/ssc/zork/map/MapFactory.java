package io.muic.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;

public class MapFactory {
    public static Map createMap(MapType mapType) {
        try {
            System.out.println("The map is succesfully created");
            return mapType.getMapClass().getConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Failed to create map");
            e.printStackTrace();
            return null;
        }
    }
}
