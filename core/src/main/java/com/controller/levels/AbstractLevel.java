package com.controller.levels;

// === Importations ===
// LibGDX

// Engine
import com.model.world.GameWorld;
import com.model.world.MapLoader;

// Java
// ====================

/**
 * Implémentation partielle commune aux niveaux (gestion du niveau suivant).
 */
public abstract class AbstractLevel implements Level {
    private Level nextLevel;

    // Constructeurs
    public AbstractLevel() {

    }

    // GETTERS

    // SETTERS
    public void setNextLevel(Level lvl) {
        if (this.nextLevel != null) {
            throw new IllegalAccessError();
        } else {
            this.nextLevel = lvl;
        }
    }

    // Méthodes
    public GameWorld setUpGameWorld(String mapPath) {
        MapLoader map = new MapLoader(); 
        map.loadMap(mapPath);
        GameWorld world = new GameWorld(map.getCurrentMap());
        return world;
    }
    
}
