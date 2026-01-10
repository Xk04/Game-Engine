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
 * Cette classe initialise le {@code Manager} et l'écran principale {@code GameScreen}
 */
public class Main extends Game {
    private GameEngine gameEngine;

    // Méthodes
    @Override
    public void create() {
        System.out.println("\n> === Game Engine === <");
        this.gameEngine = new GameEngine();
        this.setScreen(new GameScreen(this.gameEngine.getGameWorld()));
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        this.gameEngine.update(dt);
        this.gameEngine.render(dt);
    }

    @Override
    public void dispose() {
        this.getScreen().dispose();
        System.out.println("> Fenêtre fermée");
        System.out.println("> =================== <");
    }
}
