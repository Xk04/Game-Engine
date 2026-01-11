package com.view.screen;


// === Importations ===
// LibGDX
import com.badlogic.gdx.Screen;
// Engine
import com.model.world.GameWorld;
import com.view.render.WorldRenderer;
import com.view.camera.CameraManager;
import com.model.entities.Entity;
import com.model.components.concreteComponents.PositionComponent;
// Java
// ====================



public class GameScreen implements Screen {

    private GameWorld world;
    private WorldRenderer worldRenderer;
    private CameraManager cameraManager;

    
    // Constructeurs
    public GameScreen(GameWorld world) {
        this.world = world;
        
        this.cameraManager = new CameraManager(
            800, 480,
            this.world.getMapWidth(),
            this.world.getMapHeight()
        );
        System.out.println("⭢ GameScreen: ok");
        this.worldRenderer = new WorldRenderer(world, cameraManager);
    }


    // SETTERS
    public void setWorld(GameWorld newWorld) {
        if (this.world != newWorld) {
            this.world = newWorld;
            // Mettre à jour le renderer et la caméra avec le nouveau monde
            this.worldRenderer = new WorldRenderer(newWorld, cameraManager);
            // Réinitialiser la caméra si nécessaire
            this.cameraManager.setMapWidth(newWorld.getMapWidth());
            this.cameraManager.setMapHeight(newWorld.getMapHeight());
        }
    }

    @Override
    public void render(float delta) {
        this.update(delta);
        this.worldRenderer.render();
    }

    private void update(float delta) {
        Entity player = world.getEntities().get("player1");
        if (player != null) {
            PositionComponent pos = player.getComponent(PositionComponent.class);
            
            if (pos != null) {
                this.cameraManager.setTarget(pos.getX(), pos.getY());
            }
        }

        this.cameraManager.update();
    }


    // GETTERS
    public GameWorld getWorld() {
        return this.world;
    }

    public WorldRenderer getWorldRenderer() {
        return this.worldRenderer;
    }

    public CameraManager getCameraManager() {
        return this.cameraManager;
    }


    // SETTERS
    public void setWorldRenderer(WorldRenderer neWworldRenderer){
        this.worldRenderer = neWworldRenderer;
    }

    public void setCameraManager(CameraManager newCameraManager){
        this.cameraManager = newCameraManager;
    }


    // Méthodes
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
