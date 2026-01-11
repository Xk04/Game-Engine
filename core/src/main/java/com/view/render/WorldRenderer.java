package com.view.render;


// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.model.world.GameWorld;
// Engine
import com.view.camera.CameraManager;
// Java
// ====================



/**
 * Responsable du rendu du monde (carte Tiled et entités).
 * <p>
 * Utilise un {@link com.view.camera.CameraManager} pour définir la vue
 * et un {@link com.badlogic.gdx.graphics.g2d.SpriteBatch} pour dessiner.
 */
public class WorldRenderer {

    private MapRenderer mapRenderer;
    private EntityRenderer entityRenderer;
    private GameWorld world;
    private CameraManager camera;
    private SpriteBatch batch;
    
    // Constructeurs
    public WorldRenderer(GameWorld newWorld, CameraManager newCamera) {
        this.world = newWorld;
        this.camera = newCamera;
        this.batch  = new SpriteBatch();

        this.mapRenderer = new MapRenderer(this.world.getTiledMap());
        this.entityRenderer = new EntityRenderer();
        System.out.println("⭢ WorldRenderer: ok");

    }


    // GETTERS
    public MapRenderer getMapRenderer() {
        return this.mapRenderer;
    }

    public EntityRenderer getEntityRenderer() {
        return this.entityRenderer;
    }

    public GameWorld getWorld() {
        return this.world;
    }

    public CameraManager getCamera() {
        return this.camera;
    }

    public SpriteBatch getBatch() {
        return this.batch;
    }


    // SETTERS    
    public void setMapRenderer(MapRenderer mapRenderer) {
        this.mapRenderer = mapRenderer;
    }

    public void setEntityRenderer(EntityRenderer entityRenderer) {
        this.entityRenderer = entityRenderer;
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    public void setCamera(CameraManager camera) {
        this.camera = camera;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    
    // Méthodes
    /** Effectue le rendu de la carte et des entités. */
    public void render() {
        this.mapRenderer.render(this.camera);
        this.entityRenderer.render(this.world, this.camera);
    }

    public void dispose() {
        batch.dispose();
        mapRenderer.dispose();
    }

}
