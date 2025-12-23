package com.controller;

// === Importations ===
// LibGDX
// Engine
import com.model.world.GameWorld;
import com.controller.levels.LevelManager;
// Java
// ====================



/**
 * Point d'accès central aux sous-systèmes du moteur (niveaux, caméra, world).
 * <p>
 * Cette classe construit et expose les managers/contrôleurs nécessaires
 * au fonctionnement du jeu.
 */
public class Manager {
    private GameWorld gameWorld;
    private LevelManager levelManager;
    

    // Constructeurs
    public Manager() {
        System.out.println("> Importation du Manager: ok");
        System.out.println("> Importations des Controllers:");
        this.setGameScreen();
    }

    // GETTERS
    public GameWorld getGameWorld() {
        return this.gameWorld;
    }

    public LevelManager getLevelManager() {
        return this.levelManager;
    }


    // SETTERS
    public void setGameScreen() {
        this.levelManager = new LevelManager();
        this.gameWorld = this.levelManager.loadCurrentLevel();
    }



    // Méthodes


}
