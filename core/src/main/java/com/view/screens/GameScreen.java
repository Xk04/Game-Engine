package com.view.screens;

import com.badlogic.gdx.Gdx;
// === Importations ===
// LibGDX
import com.badlogic.gdx.Screen;
// Engine
import com.model.world.GameWorld;
import com.view.render.WorldRenderer;
import com.view.camera.CameraManager;
import com.model.entities.Entity;
import com.model.components.concreteComponents.PositionComponent;
import com.model.entities.Player;
import com.controller.PlayerController;
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

        Entity entityPlayer = this.world.getPlayer();
        
        if (entityPlayer instanceof Player) {
            Player player = (Player) entityPlayer;
            
            this.controller = new PlayerController(player);
            
            Gdx.input.setInputProcessor(this.controller);
            System.out.println("> Contrôles activés !");
        } else {
            System.out.println(" ERREUR : Le joueur n'est pas trouvé ou n'est pas une instance de Player !");
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
