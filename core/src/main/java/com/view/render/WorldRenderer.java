package com.view.render;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

// Engine
import com.model.world.GameWorld;
import com.model.entities.Entity;
import com.controller.camera.CameraManager;

// Java
// ====================

/**
 * Responsable du rendu du monde (carte Tiled et entités).
 * <p>
 * Utilise un {@link com.controller.camera.CameraManager} pour définir la vue
 * et un {@link com.badlogic.gdx.graphics.g2d.SpriteBatch} pour dessiner.
 */
public class WorldRenderer {
    private GameWorld world;
    private Entity player;
    private SpriteBatch batch;
    private OrthogonalTiledMapRenderer mapRenderer;
    private CameraManager camera;

    // Constructeurs
    public WorldRenderer(GameWorld gameWorld, CameraManager newCamera) {
        this.world = gameWorld;
        this.batch = new SpriteBatch();
        this.camera = newCamera;
        this.mapRenderer = new OrthogonalTiledMapRenderer(world.getTiledMap());
        System.out.println("> Importation du world render: ok");

    }

    // GETTERS

    // SETTERS

    // Méthodes
    /** Effectue le rendu de la carte et des entités. */
    public void render() {
        mapRenderer.setView(camera.getCamera());
        mapRenderer.render();
        batch.begin();

        batch.end();
    }

    /** Rendu du joueur décentralisé pour aléger le code*/
    public void playerRender() {
        float playerX = 100;
        float playerY = 100;
        this.camera.follow(playerX, playerY, 0, 0);
    }
}
