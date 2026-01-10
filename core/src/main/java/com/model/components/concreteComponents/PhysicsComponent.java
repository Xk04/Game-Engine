package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================

public class PhysicsComponent extends Component {
    public float moveSpeed;
    public float jumpForce;
    public float gravity;   
    private boolean isGrounded;
    

    // Constructeur
    public PhysicsComponent() {
        this.setMoveSpeed(180f);
        this.setJumpForce(400f);
        this.setGravity(-1000f);
        this.setIsGrounded(false);
    }

    // GETTERS
    public float getMoveSpeed() {
        return moveSpeed;
    }

    public float getJumpForce() {
        return jumpForce;
    }
    
    public float getGravity() {
        return gravity;
    }
    
    public boolean isIsGrounded() {
        return isGrounded;
    }

    // SETTERS
    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public void setJumpForce(float jumpForce) {
        this.jumpForce = jumpForce;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setIsGrounded(boolean isGrounded) {
        this.isGrounded = isGrounded;
    }
}