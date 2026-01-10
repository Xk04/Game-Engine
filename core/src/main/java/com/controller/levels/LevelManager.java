package com.controller.levels;

// === Importations ===
// LibGDX
// Engine
import com.controller.levels.concreteLevels.*;
import com.model.world.GameWorld;
// Java
import java.util.LinkedList;
import java.util.ListIterator;
// ====================


/**
 * Gère le chargement et la sélection du niveau courant.
 */
public class LevelManager {
    private LinkedList<Level> levels;
    private ListIterator<Level> levelsIterator;
    private Level currentLevel;

    // Constructeurs
    public LevelManager() {
        this.levels = new LinkedList<>();
        this.levels.add(new StartingPoint());
        this.levels.add(new Level1());
        this.levels.add(new Level2());
        this.setLevelsIterator();
        System.out.println("  | LevelManager: ok");
    }

    // GETTERS
    public LinkedList<Level> getLevels() {
        return this.levels;
    }

    public ListIterator<Level> getLevelsIterator() {
        return this.levelsIterator;
    }

    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    // SETTERS
    public void setLevelsIterator() {
        this.levelsIterator = this.levels.listIterator();
        this.setCurrentLevel(this.levelsIterator.next());
    }

    public void setCurrentLevel(Level newLevel) {
        this.currentLevel = newLevel;
    }


    // Méthodes
    public boolean hasNextLevel() {
        return this.levelsIterator.hasNext();
    }

    public GameWorld loadCurrentLevel() {
        return this.currentLevel.setUpGameWorld();
    }

    public GameWorld loadNextLevel() {
        if (!this.hasNextLevel()) {
            return null;
        } else {
            this.setCurrentLevel(this.levelsIterator.next());
        }
        return this.currentLevel.setUpGameWorld();
    }
}
