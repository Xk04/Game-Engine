package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;

// Engine
import com.model.components.Component;
import com.model.entities.Entity;

// Java
import java.util.List;
// ====================

public class PlayerPhysicsComponent extends Component {
    // === Réglages Physiques ===
    public float moveSpeed = 180f;
    public float jumpForce = 400f;
    public float gravity = 900f;   
    private boolean isGrounded = false;
    

    // Constructeur
    public PlayerPhysicsComponent() {
    }

    // getter et setter
    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getJumpForce() {
        return jumpForce;
    }

    public void setJumpForce(float jumpForce) {
        this.jumpForce = jumpForce;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public boolean isIsGrounded() {
        return isGrounded;
    }

    public void setIsGrounded(boolean isGrounded) {
        this.isGrounded = isGrounded;
    }

    
    public void update(Entity entity, float deltaTime, List<Rectangle> walls) {

        PositionComponent position = entity.getComponent(PositionComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
        HitboxComponent hitbox = entity.getComponent(HitboxComponent.class);
        StateComponent state = entity.getComponent(StateComponent.class);
        InputComponent input = entity.getComponent(InputComponent.class);

        if (position == null || velocity == null || hitbox == null || state == null) return;

        velocity.setVX(0);
        if (input != null) {
            if (input.isLeft()) {
                velocity.setVX(-moveSpeed);
                state.setDirection(false); 
                if (isGrounded) state.setEtatCourant(StateComponent.RUN);
            }
            else if (input.isRight()) {
                velocity.setVX(moveSpeed);
                state.setDirection(true); 
                if (isGrounded) state.setEtatCourant(StateComponent.RUN);
            } 
            else {
                if (isGrounded) state.setEtatCourant(StateComponent.IDLE);
            }

            // Saut
            if (input.isSpace() && isGrounded) {
                velocity.setVY(jumpForce);
                isGrounded = false;
                state.setEtatCourant(StateComponent.JUMP);
            }
        }
        
    }
}
