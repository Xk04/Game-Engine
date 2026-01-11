package com;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
// Engine
import com.controller.GameEngine;
import com.view.screens.GameScreen;
// Java
// ====================

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */

/**
 * Point d'entrée du moteur de jeu.
 * <p>
 * Cette classe initialise le {@code Manager} et l'écran principale
 * {@code GameScreen}
 */
public class Main extends Game {
    private GameEngine gameEngine;

    // Constructeurs (pour les tests)
    public Main() {
    }

    public Main(GameEngine engine) {
        this.gameEngine = engine;
    }

    // GETTER
    public GameEngine getGameEngine() {
        return gameEngine;
    }

    // SETTER
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    // Méthodes
    @Override
    public void create() {
        System.out.println("\n> === Game Engine === <");

        if (this.gameEngine == null) {
            this.gameEngine = new GameEngine();
        }

        if (Gdx.graphics != null) {
            this.setScreen(new GameScreen(this.gameEngine.getGameWorld()));
        }

    }

    @Override
    public void render() {
        if (Gdx.graphics == null) {
            return;
        }

        float dt = Gdx.graphics.getDeltaTime();
        if (this.gameEngine != null) {
            this.gameEngine.update(dt);
            this.gameEngine.render(dt);
        }
    }

    @Override
    public void dispose() {

        if (this.getScreen() != null) {
            this.getScreen().dispose();
        }
        System.out.println("> Fenêtre fermée");
        System.out.println("> =================== <");
    }

}
