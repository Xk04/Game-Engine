package com;


// === Importations ===
// LibGDX
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
// Engine
import com.controller.GameEngine;
import com.view.screen.GameScreen;
// ====================


/**
 * Point d'entrée du moteur de jeu.
 * <p>
 * Cette classe initialise le {@code GameEngine} et l'écran principale {@code GameScreen}
 */
public class Main extends Game {
    
    private GameEngine gameEngine;

    
    // Méthodes
    @Override
    public void create() {
        System.out.println("\n> ========== Game Engine ========== <");
        this.gameEngine = new GameEngine();
        this.setScreen(new GameScreen(this.gameEngine.getGameWorld()));
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        this.gameEngine.update(dt);
        ((GameScreen) this.getScreen()).setWorld(this.gameEngine.getGameWorld());
        super.render();
    }

    @Override
    public void dispose() {
        this.getScreen().dispose();
        System.out.println("> Fenêtre fermée");
        System.out.println("> =================================== <");
    }
}
