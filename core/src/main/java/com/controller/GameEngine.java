package com.controller;

// === Importations ===
// LibGDX
// Engine
import com.model.world.GameWorld;
import com.view.screens.GameScreen;
import com.controller.inputs.InputManager;
import com.controller.levels.LevelManager;
import com.model.entities.Entity;
// Java
// ====================



/**
 * Point d'accès central aux sous-systèmes du moteur (niveaux, caméra, world).
 * <p>
 * Cette classe construit et expose les managers/contrôleurs nécessaires
 * au fonctionnement du jeu.
 */
public class GameEngine {
    private GameWorld gameWorld;
    private LevelManager levelManager;
    private InputManager inputManager;
    private GameScreen gameScreen;

    // Constructeurs
    public GameEngine() {
        System.out.println("> Importation du Moteur: ok");
        System.out.println("> Importations des Controllers:");

        this.levelManager = new LevelManager();
        this.gameWorld = this.levelManager.loadCurrentLevel();
        Entity player = this.gameWorld.getEntities().get("player1");
        this.inputManager = new InputManager(player);
        this.gameScreen = new GameScreen(gameWorld);
    }

    /**
     * Constructeur dédié aux Tests Unitaires (Injection de dépendances).
     * Permet de créer un moteur avec des faux objets pour éviter de charger les graphismes.
     */
    public GameEngine(LevelManager levelManager, GameWorld gameWorld, InputManager inputManager, GameScreen gameScreen) {
        this.levelManager = levelManager;
        this.gameWorld = gameWorld;
        this.inputManager = inputManager;
        this.gameScreen = gameScreen;
    }

    // GETTERS
    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }


    // SETTERS    
    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public void setInputController(InputManager inputController) {
        this.inputManager = inputController;
    }

    // Méthodes
    public void update(float dt) {
        //this.inputManager.update(this.gameWorld, dt);
        this.gameWorld.update(dt);
    }

    public void render(float dt) {
        this.gameScreen.render(dt);
    }

}
