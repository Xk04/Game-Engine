package com.controller.levels;

// === Importations ===
// LibGDX
// Engine
import com.model.world.GameWorld;
import com.controller.levels.concreteLevels.*;
// Java
// ====================



/**
 * Gère le chargement et la sélection du niveau courant.
 */
public class LevelManager {
    private GameWorld currentGameWorld;

    // Constructeurs
    public LevelManager() {
        System.out.println("  | LevelManager: ok");
        Level level1 = new StartingPoint();
        this.setGameWorld(level1, "maps/level1.tmx");
    }

    // GETTERS
    public GameWorld getGameWorld() {
        return this.currentGameWorld;
    }

    // SETTERS
    private void setGameWorld(Level lvl, String mapPath) {
        this.currentGameWorld = lvl.setUpGameWorld(mapPath);
    }

    // Méthodes

}
