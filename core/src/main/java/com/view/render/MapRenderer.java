package com.view.render;

// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
// Engine
import com.view.camera.CameraManager;
// Java
// ====================


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