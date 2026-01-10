package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================

public class PositionComponent extends Component {
    private float x;
    private float y;
    private float[] pos;

    // Constructeurs
    public PositionComponent(float newX, float newY) {
        this.setX(newX);
        this.setY(newY);
        this.setPos(newX, newY);
    }

    // GETTERS
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
    
    public float[] getPos() {
        return this.pos;
    }

    // SETTERS
    public void setX(float newX){
        this.x = newX;
    }
    
    public void setY(float newY){
        this.y = newY;
    }
    
    public void setPos(float newX, float newY) {
        this.pos = new float [2];
        this.pos[0] = newX;
        this.pos[1] = newY;
    }

    // Méthodes
}