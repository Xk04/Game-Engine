package com.controller.camera;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
// Engine
// Java
import com.badlogic.gdx.math.MathUtils;
// ====================



/**
 * Gère la caméra orthographique du jeu et son viewport.
 * <p>
 * Fournit des utilitaires pour suivre une entité, contraindre la caméra
 * aux limites de la carte et redimensionner le viewport.
 */
public class CameraManager {
    private OrthographicCamera camera;
    private Viewport viewport;
    private float mapWidth;
    private float mapHeight;

    // Constructeurs
    public CameraManager(float width, float height, float mapWidth, float mapHeight) {
        this.camera = new OrthographicCamera();
        this.camera.zoom -= 0.3;
        this.viewport = new ExtendViewport(width, height, width, height, this.camera);
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        System.out.println("  | CameraManager: ok");
    }

    // GETTERS
    public OrthographicCamera getCamera() {
        return this.camera;
    }

    public float getMapWidth() {
        return this.mapWidth;
    }
    
    public float getMapHeight() {
        return this.mapHeight;
    }

    // SETTERS
    public void setMapWidth(float width) {
        if (width <= 0) {
            throw new IllegalAccessError("\n> Impossible d'assigner une largeur négative à la caméra:\n|  Détails: camera.setMapWidth(" + width + ") ---> Impossible\n");
        } else {
            this.mapWidth = width;
        }
    }

    public void setMapHeight(float height) {
        if (height <= 0) {
            throw new IllegalAccessError("\n> Impossible d'assigner une hauteur négative à la caméra:\n|  Détails: camera.setMapHeight(" + height + ") ---> Impossible\n");
        } else {
            this.mapHeight = height;
        }
    }

    // Méthodes
    /** Contraint la position de la caméra pour rester dans les limites de la carte. */
    public void clampCamera() {
        float halfViewW = (this.camera.viewportWidth * this.camera.zoom) / 2f;
        float halfViewH = (this.camera.viewportHeight * this.camera.zoom) / 2f;

        if (this.camera.viewportWidth * this.camera.zoom > this.mapWidth) {
            this.camera.position.x = this.mapWidth / 2f;
        } else {
            this.camera.position.x = MathUtils.clamp(this.camera.position.x, halfViewW, this.mapWidth - halfViewW);
        }

        if (this.camera.viewportHeight * this.camera.zoom > this.mapHeight) {
            this.camera.position.y = this.mapHeight / 2f;
        } else {
            this.camera.position.y = MathUtils.clamp(this.camera.position.y, halfViewH, this.mapHeight - halfViewH);
        }
    }

    /**
     * Place la caméra pour suivre une position donnée, avec offset.
     * @param x position x cible
     * @param y position y cible
     * @param offsetX décalage en x
     * @param offsetY décalage en y
     */
    public void follow(float x, float y, float offsetX, float offsetY) {
        this.camera.position.set(x+offsetX, y+offsetY, 0);
        clampCamera();
        this.camera.update();
    }

    /** Met à jour la taille du viewport et la caméra lors d'un redimensionnement. */
    public void resize(int width, int height) {
        this.viewport.update(width, height, true); 
        this.camera.update();
    }
}
 