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
    private boolean space;


    // Constructeurs
    public InputComponent() {
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
        this.space = false;
    }


    // GETTERS
    public boolean isUp() {
        return this.up;
    }

    public boolean isDown() {
        return this.down;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isSpace() {
        return space;
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

    public void setSpace(boolean space) {
        this.space = space;
    }
    

    // Méthodes
}