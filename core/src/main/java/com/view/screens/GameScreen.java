package com.view.screens;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
// Engine
import com.model.world.GameWorld;
import com.view.render.WorldRenderer;
import com.view.camera.CameraManager;
import com.controller.PlayerController;
import com.model.entities.Entity;
import com.model.components.concreteComponents.PositionComponent;
import com.model.components.concreteComponents.InputComponent;
// Java
// ====================


public class GameScreen implements Screen {

    private final GameWorld world;
    private final WorldRenderer worldRenderer;
    private final CameraManager cameraManager;
    private PlayerController controller;

    public GameScreen(GameWorld world) {
        this.world = world;

        this.cameraManager = new CameraManager(
            800, 480,
            this.world.getMapWidth(),
            this.world.getMapHeight()
        );

        this.worldRenderer = new WorldRenderer(world, cameraManager);
        Entity player = world.getEntities().get("player1");
        if (player != null) {
            InputComponent input = player.getComponent(InputComponent.class);
            if (input != null) {
                this.controller = new PlayerController(player);
                Gdx.input.setInputProcessor(this.controller);
                System.out.println("> Contrôles clavier activés pour player1");
            }
        }
    }

    @Override
    public void render(float delta) {
        this.update(delta);
        this.worldRenderer.render();
    }

    private void update(float delta) {
        this.world.update(delta);
        Entity player = world.getEntities().get("player1");
        if (player != null) {
            PositionComponent pos = player.getComponent(PositionComponent.class);
            
            if (pos != null) {
                this.cameraManager.setTarget(pos.getX(), pos.getY());
            }
        }

        this.cameraManager.update();
    }

    @Override
    public void resize(int width, int height) {
        this.cameraManager.resize(width, height);
    }

    @Override 
    public void show() {}

    @Override 
    public void pause() {}

    @Override 
    public void resume() {}

    @Override 
    public void hide() {}

    @Override
    public void dispose() {
        this.worldRenderer.dispose();
    }
}
