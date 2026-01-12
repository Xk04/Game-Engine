package com.view.render;


// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
// Engine
import com.view.camera.CameraManager;
// Java
// ====================



/**
 * Rendu de la carte Tiled du jeu.
 * <p>
 * Cette classe utilise un OrthogonalTiledMapRenderer pour afficher
 * les couches de la carte en fonction de la position de la caméra.
 */
public class MapRenderer {

    private OrthogonalTiledMapRenderer renderer;


    // Constructeurs
    public MapRenderer(TiledMap map) {
        this.renderer = new OrthogonalTiledMapRenderer(map);
    }


    // GETTERS
    public OrthogonalTiledMapRenderer getRenderer() {
        return renderer;
    }


    // SETTERS
    public void setRenderer(OrthogonalTiledMapRenderer renderer) {
        this.renderer = renderer;
    }


    // Méthodes
    public void render(CameraManager camera) {
        camera.getCamera().update();
        this.renderer.setView(camera.getCamera());
        this.renderer.render();
    }

    public void dispose() {
        renderer.dispose();
    }
}