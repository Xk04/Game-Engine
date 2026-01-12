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



/**
 * Écran principal du jeu implémentant l'interface Screen de LibGDX.
 * <p>
 * Cette classe gère le rendu du monde du jeu, la mise à jour des entités
 * et la gestion de la caméra pendant le gameplay.
 */
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
        System.out.println("-> GameScreen: ok");
        this.worldRenderer = new WorldRenderer(world, cameraManager);
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
    
    public void setWorld(GameWorld newWorld) {
        if (this.world != newWorld) {
            this.world = newWorld;
            this.worldRenderer = new WorldRenderer(newWorld, cameraManager);
            this.cameraManager.setMapWidth(newWorld.getMapWidth());
            this.cameraManager.setMapHeight(newWorld.getMapHeight());
        }
    }


    // Méthodes
    // Méthodes
    /**
     * Renders the game screen.
     * @param delta the time delta
     */
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
