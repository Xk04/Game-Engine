package com.controller;

// === Importations ===
// LibGDX
// Engine
import com.model.world.GameWorld;
import com.controller.levels.LevelManager;
import com.controller.camera.CameraManager;
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
    private CameraManager camera;

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

    public CameraManager getCameraManager() {
        return this.camera;
    }

    // SETTERS
    public void setGameScreen() {
        this.camera = new CameraManager(800, 480, 0, 0);

        this.levelManager = new LevelManager();

        this.gameWorld = this.levelManager.getGameWorld();

        this.camera.setMapWidth(this.gameWorld.getMapWidth());
        this.camera.setMapHeight(this.gameWorld.getMapHeight());
    }

    // Méthodes


}
