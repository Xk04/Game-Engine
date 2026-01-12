package com.model.components.concreteComponents;


// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================



public class VelocityComponent extends Component {

    private float vx;
    private float vy;
    private float[] velocity;


    // Constructeurs
    public VelocityComponent(float newVX, float newVY) {
        this.setVX(newVX);
        this.setVY(newVY);
        this.setVelocity(newVX, newVY);
    }


    // GETTERS
    public float getVX() {
        return this.vx;
    }
    
    public float getVY() {
        return this.vy;
    }
    
    public float[] getVelocity() {
        return this.velocity;
    }


    // SETTERS
    public void setVX(float newVX){
        this.vx = newVX;
    }
    
    public void setVY(float newVY){
        this.vy = newVY;
    }
    
    public void setVelocity(float newVX, float newVY) {
        this.velocity = new float [2];
        this.velocity[0] = newVX;
        this.velocity[1] = newVY;
    }


    // Méthodes
}