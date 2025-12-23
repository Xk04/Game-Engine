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
        this.setBounds(x, y, width, height);
    }

    // GETTERS
    public Rectangle getBounds() {
        return this.bounds;
    }

    // SETTERS
    public void setBounds(float x, float y, float width, float height) {
        this.bounds = new Rectangle(x, y, width, height);
    }

    // Méthodes
    
}
