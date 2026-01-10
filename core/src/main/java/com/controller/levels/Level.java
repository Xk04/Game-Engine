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
public abstract class Level {
    private String mapPath;

    // Constructeurs
    public Level(String newMapPath) {
        this.setMapPath(newMapPath);
    }

    // GETTERS
    public String getMapPath() {
        return this.mapPath;
    }

    // SETTERS
    public void setMapPath(String newMapPath) {
        if (newMapPath == "") {
            throw new IllegalAccessError("\n> Impossible d'intancier un nom de carte \"\" dans le gestionnaire de niveaux");
        } else if (newMapPath == null) {
            throw new IllegalAccessError("\n> Impossible d'intancier une carte vide dans le gestionnaire de niveaux");
        } else {
            this.mapPath = newMapPath;
        }
    }


    // Méthodes
    public GameWorld setUpGameWorld() {
        MapLoader map = new MapLoader(); 
        map.loadMap(this.mapPath);
        GameWorld world = new GameWorld(map, "", null);
        return world;
    }
    
}
