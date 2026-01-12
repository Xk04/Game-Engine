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



/**
 * Système de physique pour appliquer les lois physiques aux entités.
 * <p>
 * Ce système gère la gravité, les mouvements, les sauts et les interactions
 * physiques basées sur les composants de physique des entités.
 */
public class PhysicsSystem implements UpdateInterface {

    // Méthodes
    /**
     * Updates the physics for the given entity.
     * @param mapLoader the map loader
     * @param entitySet the entity entry
     * @param deltaTime the time delta
     * @return false (physics update doesn't trigger level completion)
     */
    public static boolean update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {
        Entity entity = entitySet.getValue();

        PositionComponent position = entity.getComponent(PositionComponent.class);
        PhysicsComponent physics = entity.getComponent(PhysicsComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
        HitboxComponent hitbox = entity.getComponent(HitboxComponent.class);
        StateComponent state = entity.getComponent(StateComponent.class);
        InputComponent input = entity.getComponent(InputComponent.class);
        
        List<Rectangle> walls = mapLoader.getCollisionRectangles();
        
        if (position == null || hitbox == null || state == null)
            return false;

        velocity.setVX(0);

        if (input != null) {

            if (input.isLeft()) {
                velocity.setVX(-physics.getMoveSpeed());
                state.setDirection(false);
                if (physics.isIsGrounded()) {
                    if (state.getEtatCourant() != StateComponent.RUN) {
                        state.setEtatCourant(StateComponent.RUN);
                        state.setStateTime(0f);
                    }
                }
            }
            else if (input.isRight()) {
                velocity.setVX(physics.getMoveSpeed());
                state.setDirection(true);
                if (physics.isIsGrounded()) {
                    if (state.getEtatCourant() != StateComponent.RUN) {
                        state.setEtatCourant(StateComponent.RUN);
                        state.setStateTime(0f);
                    }
                }
            }
            else {
                if (physics.isIsGrounded()) {
                    if (state.getEtatCourant() != StateComponent.IDLE) {
                        state.setEtatCourant(StateComponent.IDLE);
                        state.setStateTime(0f);
                    }
                }
            }
            if (input.isSpace() && physics.isIsGrounded()) {
                velocity.setVY(physics.getJumpForce());
                physics.setIsGrounded(false);

                state.setEtatCourant(StateComponent.JUMP);
                state.setStateTime(0f);
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
        return false;
    }
}