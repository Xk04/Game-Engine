package com.model.systems;


// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
// Engine
import com.model.components.concreteComponents.HitboxComponent;
import com.model.components.concreteComponents.PositionComponent;
import com.model.components.concreteComponents.VelocityComponent;
import com.model.world.MapLoader;
import com.model.entities.Entity;
// Java
import java.util.Map;
// ====================



/**
 * Système de gestion des collisions entre entités et avec la carte.
 * <p>
 * Ce système détecte et résout les collisions en ajustant les positions
 * et vitesses des entités en fonction de leurs hitboxes.
 */
public class CollisionSystem implements UpdateInterface {

    // Méthodes
    private static void checkPlayerFall(Entity player, Vector2 spawnLocation) {
        if (player != null) {
            PositionComponent pos = player.getComponent(PositionComponent.class);
            if (pos != null && pos.getY() < -300) {
                respawnPlayer(player, spawnLocation);
            }
        }
    }

    private static void respawnPlayer(Entity player, Vector2 spawnLocation) {
        if (spawnLocation == null)
            return;
        
        PositionComponent pos = player.getComponent(PositionComponent.class);
        VelocityComponent vel = player.getComponent(VelocityComponent.class);
        HitboxComponent hitbox = player.getComponent(HitboxComponent.class);

        if (pos != null) {
            pos.setX(spawnLocation.x);
            pos.setY(spawnLocation.y);
        }

        if (vel != null) {
            vel.setVX(0);
            vel.setVY(0);
        }

        if (hitbox != null) {
            hitbox.setX(spawnLocation.x);
            hitbox.setY(spawnLocation.y);
        }
    }

    /**
     * Updates the collision detection for the given entity.
     * @param mapLoader the map loader
     * @param entitySet the entity entry
     * @param deltaTime the time delta
     * @return true if the player reaches the end zone, false otherwise
     */
    public static boolean update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {
        String key = entitySet.getKey();
        Entity entity = entitySet.getValue();

        Rectangle endZone = mapLoader.getEndZone();
        if (endZone != null) {
            if ("player1".equals(key)) {
                HitboxComponent hitbox = entity.getComponent(HitboxComponent.class);
                if (hitbox != null && hitbox.getBounds().overlaps(endZone)) {
                    return true;
                }
            }
        }
        checkPlayerFall(entity, mapLoader.getPlayerStart());
        return false;
    }
}