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


    // Constructeurs
    public PositionComponent(float newX, float newY) {
        this.setX(newX);
        this.setY(newY);
    }


    // GETTERS
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }


    // SETTERS
    public void setX(float newX){
        this.x = newX;
    }
    
    public void setY(float newY){
        this.y = newY;
    }

    
    // Méthodes
}