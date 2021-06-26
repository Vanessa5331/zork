package io.muic.ssc.zork.map;

import java.lang.reflect.InvocationTargetException;

public class MapFactory {
    public static Map createMap(MapType mapType) {
        try {
            return mapType.getMapClass().getConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Failed to create map");
            e.printStackTrace();
            return null;
        }
    }

    public static Map duplicateMap(Map map, Room currentRoom) {
        Class<? extends Map> mapClass = map.getClass();

        if(mapClass.equals(DefaultMap.class)) {
            return new DefaultMap((DefaultMap) map, currentRoom);
        } else if (mapClass.equals(HardMap.class)) {
            return new HardMap((HardMap) map, currentRoom);
        }

        return null;
    }
}
