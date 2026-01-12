package com.controller.managers;


// === Importations ===
// LibGDX
// Engine
import com.controller.levels.concreteLevels.*;
import com.model.world.GameWorld;
import com.controller.levels.Level;
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
        System.out.println("-> LevelManager:");
        this.levels = new LinkedList<>();
        this.levels.add(new StartingPoint());
        this.levels.add(new Level1());
        this.levels.add(new Level2());
        
        this.setLevelsIterator();
        this.loadCurrentLevel();

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
    /**
     * Vérifie s'il y a un niveau suivant disponible.
     *
     * @return true si un niveau suivant existe, false sinon.
     */
    public boolean hasNextLevel() {
        return this.levelsIterator.hasNext();
    }

    /**
     * Charge et retourne le monde du jeu pour le niveau actuel.
     *
     * @return le GameWorld du niveau actuel.
     * @throws IllegalAccessError si le niveau actuel est null.
     */
    public GameWorld loadCurrentLevel() {
        Level currentLevel = this.getCurrentLevel();
        if (currentLevel == null) {
            throw new IllegalAccessError("Un niveau ne peut pas être chargé s'il est vide");
        } else {
            return this.currentLevel.setUpGameWorld();
        }
    }

    /**
     * Charge le niveau suivant et retourne son monde du jeu.
     *
     * @return le GameWorld du niveau suivant, ou null s'il n'y a pas de niveau suivant.
     */
    public GameWorld loadNextLevel() {
        if (!this.hasNextLevel()) {
            return null;
        } else {
            this.setCurrentLevel(this.levelsIterator.next());
        }
        return this.currentLevel.setUpGameWorld();
    }
}
