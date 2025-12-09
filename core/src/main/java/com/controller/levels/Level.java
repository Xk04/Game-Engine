package com.controller.levels;

// === Importations ===
// LibGDX

// Engine
import com.model.world.GameWorld;

// Java
// ====================

/**
 * Interface représentant un niveau de jeu (chargement du GameWorld).
 */
public interface Level {
    /** Définit le niveau suivant. */
    public void setNextLevel(Level lvl);

    /** Initialise et retourne le {@link GameWorld} correspondant au niveau. */
    public GameWorld setUpGameWorld(String mapPath);
}
