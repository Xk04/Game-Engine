package com;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Game;
// Engine
import com.controller.Manager;
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
    private Manager manager;

    // Méthodes
    @Override
    public void create() {
        System.out.println("\n> === Game Engine === <");
        this.manager = new Manager();
        this.setScreen(new GameScreen(this.manager.getGameWorld()));
    }

    @Override
    public void dispose() {
        this.getScreen().dispose();
        System.out.println("> Fenêtre fermée");
        System.out.println("> =================== <");
    }
}
