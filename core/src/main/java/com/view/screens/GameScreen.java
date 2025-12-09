package com.view.screens;
// === Importations ===
// LibGDX
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
// Engine
import com.controller.Manager;
import com.controller.camera.CameraManager;
import com.view.render.WorldRenderer;
// Java
// ====================



/**
 * Écran principal du jeu affichant et orchestrant le rendu du monde.
 * <p>
 * Le rendu de monde est traité par {@link com.view.render.WorldRenderer}.
 * Il gère le redimensionnement de la caméra via le {@code CameraManager}.
 */
public class GameScreen implements Screen {
    private final Manager manager;
    private WorldRenderer worldRenderer;
    private CameraManager camera;

    // Constructeur
    public GameScreen(Manager newManager) {
        System.out.println("> Importation du Gamescreen: ok");
        this.manager = newManager;
        this.camera = this.manager.getCameraManager();
        this.worldRenderer = new WorldRenderer(this.manager.getGameWorld(), camera);
    }

    // GETTERS

    // SETTERS

    // Méthodes
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        this.worldRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        this.manager.getCameraManager().resize(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}