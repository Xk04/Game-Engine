package com.controller.levels.concreteLevels;

// === Importations ===
// LibGDX

// Engine
import com.model.world.GameWorld;
import com.model.world.MapLoader;
import com.controller.levels.AbstractLevel;

// Java
// ====================

/**
 * Niveau de départ (exemple) qui instancie le monde à partir d'une map.
 */
public class StartingPoint extends AbstractLevel {

    // Constructeurs
    public StartingPoint() {

    }

    // GETTERS

    // SETTERS

    // Méthodes
    @Override
    public GameWorld setUpGameWorld(String mapPath) {
        MapLoader map = new MapLoader(); 
        map.loadMap(mapPath);
        GameWorld world = new GameWorld(map.getCurrentMap());
        return world;
    }
}
