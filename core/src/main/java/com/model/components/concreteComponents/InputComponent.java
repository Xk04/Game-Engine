package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================

public class InputComponent extends Component {
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    // Constructeurs
    public InputComponent() {
        this.setUp(false);
        this.setDown(false);
        this.setLeft(false);
        this.setRight(false);
    }

    // GETTERS
    public boolean getUp() {
        return this.up;
    }
    
    public boolean getDown() {
        return this.down;
    }
    
    public boolean getLeft() {
        return this.left;
    }
    
    public boolean getRight() {
        return this.right;
    }

    // SETTERS
    public void setUp(boolean state) {
        this.up = state;
    }
    
    public void setDown(boolean state) {
        this.down = state;
    }
    
    public void setLeft(boolean state) {
        this.left = state;
    }
    
    public void setRight(boolean state) {
        this.right = state;
    }

    // Méthodes

    
}
