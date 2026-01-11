package com.view.camera;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
// Engine
// Java
// ====================



public class CameraManager {
    private final OrthographicCamera camera;
    private final Viewport viewport;

    private float mapWidth;
    private float mapHeight;
    private float targetX;
    private float targetY;


    // Constructeurs
    public CameraManager(float worldWidth, float worldHeight, float mapWidth, float mapHeight) {
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(worldWidth, worldHeight, camera);
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        System.out.println("⭢ CameraManager: ok");
    }


    // GETTERS
    public OrthographicCamera getCamera() { 
        return camera; 
    }

    public Viewport getViewport() { 
        return viewport; 
    }

    public float getMapWidth() {
        return this.mapWidth;
    }

    public float getMapHeight() {
        return this.mapHeight;
    }

    public float getTargetX() {
        return this.targetX;
    }

    public float getTargetY() {
        return this.targetY;
    }
    

    // SETTERS
    public void setTarget(float x, float y) { 
        this.targetX = x; 
        this.targetY = y; 
    }

    public void setMapWidth(float mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setMapHeight(float mapHeight) {
        this.mapHeight = mapHeight;
    }

    public void setTargetX(float targetX) {
        this.targetX = targetX;
    }

    public void setTargetY(float targetY) {
        this.targetY = targetY;
    }

    
    // Méthodes
    public void update() {
        camera.position.set(targetX, targetY, 0);
        clamp();
        camera.update();
    }

    private void clamp() {
        float effectiveViewW = camera.viewportWidth * camera.zoom;
        float effectiveViewH = camera.viewportHeight * camera.zoom;

        float halfW = effectiveViewW / 2f;
        float halfH = effectiveViewH / 2f;

        if (mapWidth < effectiveViewW) {
            camera.position.x = mapWidth / 2f;
        } else {
            camera.position.x = MathUtils.clamp(camera.position.x, halfW, mapWidth - halfW);
        }

        if (mapHeight < effectiveViewH) {
            camera.position.y = mapHeight / 2f;
        } else {
            camera.position.y = MathUtils.clamp(camera.position.y, halfH, mapHeight - halfH);
        }
    }

    public void resize(int width, int height) {
        viewport.update(width, height, false);
        float zoomX = mapWidth / camera.viewportWidth;
        float zoomY = mapHeight / camera.viewportHeight;
        float minZoomToFill = Math.min(zoomX, zoomY);
        if (minZoomToFill < 1.0f) {
            camera.zoom = minZoomToFill;
        } else {
            camera.zoom = 1.0f; 
        }
    }
}