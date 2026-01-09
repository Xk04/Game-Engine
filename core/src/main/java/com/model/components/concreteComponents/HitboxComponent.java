package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
// Engine
import com.model.components.Component;
// Java
// ====================

public class HitboxComponent extends Component {
    private Rectangle bounds;

    // Constructeurs
    public HitboxComponent(float x, float y, float width, float height) {
        this.bounds = new Rectangle(x, y, width, height);
    }

    // GETTERS
    public Rectangle getBounds() {
        return this.bounds;
    }


    public float getX() {
        return bounds.x;
    }

    public float getY() {
        return bounds.y;
    }

    public float getHeight() {
        return bounds.height;
    }

    public float getWidth() {
        return bounds.width;
    }

    // SETTERS
    public void setBounds(float x, float y, float width, float height) {
        this.bounds = new Rectangle(x, y, width, height);
    }

    /**
     * * Met à jour la position X.
     */
    public void setX(float x) {
        this.bounds.x = x;
    }

    /**
     * * Met à jour la position Y.
     */
    public void setY(float y) {
        this.bounds.y = y;
    }

    public void setPosition(float x, float y) {
        this.bounds.setPosition(x, y);
    }

    // Méthodes

}
