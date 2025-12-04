package com.model.world;

// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

// Engine
import com.model.entities.Entity;

// Java
// ====================


public class MapLoader {
    private TmxMapLoader mapLoader;
    private TiledMap currentMap;
    private String currentMapPath;

    public MapLoader() {
        this.mapLoader = new TmxMapLoader();
    }

    public GameWorld loadMap(String mapPath) {
        
    }
}


