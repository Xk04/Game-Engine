package com.controller;


// === Importations ===
// LibGDX
// Engine
import com.model.world.GameWorld;
import com.badlogic.gdx.Gdx;
import com.controller.managers.InputManager;
import com.controller.managers.LevelManager;
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


    // Constructeurs
    public GameEngine() {
        System.out.println("-> Importation du moteur");

        this.levelManager = new LevelManager();
        
        this.gameWorld = this.levelManager.getCurrentLevel().getWorld();
        Entity player = this.gameWorld.getEntities().get("player1");

        this.inputManager = new InputManager(player);
        Gdx.input.setInputProcessor(inputManager);
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
    /**
     * Met à jour le moteur de jeu pour un delta de temps donné.
     * <p>
     * Met à jour le monde du jeu et gère le passage au niveau suivant si nécessaire.
     *
     * @param dt le delta de temps écoulé depuis la dernière mise à jour.
     */
    public void update(float dt) {
        boolean levelCompleted = this.gameWorld.update(dt);
        if (levelCompleted) {
            GameWorld nextWorld = this.levelManager.loadNextLevel();
            if (nextWorld != null) {
                this.setGameWorld(nextWorld);
                Entity player = this.gameWorld.getEntities().get("player1");
                if (player != null) {
                    this.inputManager = new InputManager(player);
                    Gdx.input.setInputProcessor(inputManager);
                } else {
                    System.out.println("Erreur : Joueur non trouvé dans le nouveau niveau !");
                }
            }
        }
    }
}