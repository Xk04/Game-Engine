package com.model.systems;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
// Engine
import com.model.components.concreteComponents.HitboxComponent;
import com.model.components.concreteComponents.InputComponent;
import com.model.components.concreteComponents.PhysicsComponent;
import com.model.components.concreteComponents.PositionComponent;
import com.model.components.concreteComponents.StateComponent;
import com.model.components.concreteComponents.VelocityComponent;
import com.model.entities.Entity;
import com.model.world.MapLoader;
// Java
import java.util.List;
import java.util.Map;
// ====================



public class PhysicsSystem {
    public static void update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {
        Entity entity = entitySet.getValue();

        List<Rectangle> walls = mapLoader.getCollisionRectangles();
        PositionComponent position = entity.getComponent(PositionComponent.class);
        PhysicsComponent physics = entity.getComponent(PhysicsComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
        HitboxComponent hitbox = entity.getComponent(HitboxComponent.class);
        StateComponent state = entity.getComponent(StateComponent.class);
        InputComponent input = entity.getComponent(InputComponent.class);

        if (position == null || hitbox == null || state == null) return;

        velocity.setVX(0);
        
        if (input != null) {
            if (input.isLeft()) {
                velocity.setVX(-physics.getMoveSpeed());
                state.setDirection(false); 
                if (physics.isIsGrounded()) state.setEtatCourant(StateComponent.RUN);
            }
            else if (input.isRight()) {
                velocity.setVX(physics.getMoveSpeed());
                state.setDirection(true); 
                if (physics.isIsGrounded()) state.setEtatCourant(StateComponent.RUN);
            } 
            else {
                if (physics.isIsGrounded()) state.setEtatCourant(StateComponent.IDLE);
            }

            if (input.isSpace() && physics.isIsGrounded()) {
                velocity.setVY(physics.getJumpForce());
                physics.setIsGrounded(false);
                state.setEtatCourant(StateComponent.JUMP);
            }
        }

        
        float currentVY = velocity.getVY();
        velocity.setVY(currentVY + (physics.getGravity() * deltaTime));


        float oldX = position.getX();
        float newX = oldX + (velocity.getVX() * deltaTime); 
        
        position.setX(newX);
        hitbox.setX(newX);

        for (Rectangle wall : walls) {
            if (hitbox.getBounds().overlaps(wall)) {
                position.setX(oldX);
                hitbox.setX(oldX);
                break; 
            }
        }

        float oldY = position.getY();
        float newY = oldY + (velocity.getVY() * deltaTime);

        position.setY(newY);
        hitbox.setY(newY);
        
        physics.setIsGrounded(false);

        for (Rectangle wall : walls) {
            if (hitbox.getBounds().overlaps(wall)) {
                if (velocity.getVY() < 0) {
                    position.setY(wall.y + wall.height);
                    physics.setIsGrounded(true);
                    velocity.setVY(0);
                }
                
                else if (velocity.getVY() > 0) {
                    position.setY(wall.y - hitbox.getHeight()); 
                    velocity.setVY(0);
                }
                
                hitbox.setY(position.getY());
                break;
            }
        }
    }
}