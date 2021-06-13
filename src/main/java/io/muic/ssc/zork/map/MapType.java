package io.muic.ssc.zork.map;

public enum MapType {
    DEFAULT("default", DefaultMap.class);

    String mapName;
    Class<? extends Map> mapClass;

    MapType(String mapName, Class<? extends Map> mapClass){
        this.mapName = mapName;
        this.mapClass = mapClass;
    }

    public Class<? extends Map> getMapClass() {
        return mapClass;
    }
}