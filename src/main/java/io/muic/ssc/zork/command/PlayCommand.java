package io.muic.ssc.zork.command;

import io.muic.ssc.zork.Game;
import io.muic.ssc.zork.map.Map;
import io.muic.ssc.zork.map.MapFactory;
import io.muic.ssc.zork.map.MapType;

import java.util.List;

public class PlayCommand implements Command{
    @Override
    public void execute(Game game, List<String> args) {
        String map = "default";

        if (!args.get(0).equals("")){
            map = args.get(0);
        }

        for(MapType mapType: MapType.values()){
            if(map.equals(mapType.getMapName())) {
                Map createdMap = MapFactory.createMap(mapType);
                if(createdMap != null) {
                    game.setMap(createdMap);
                    game.setCurrentRoom(createdMap.getStartRoom());
                    game.start();
                    break;
                }
            }
        }
    }
}
