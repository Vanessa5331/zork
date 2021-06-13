package io.muic.ssc.zork.map;

public class MapFactory {
    public static void createMap(MapType mapType) {
        try {
            mapType.getMapClass().getConstructor();
            System.out.println("The map is succesfully created");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("The map failed to be created.\nYou'll be redirected to our default map!");
        }
    }
}
