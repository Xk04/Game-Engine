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



public class CollisionSystem {
    private static void checkPlayerFall(Entity player, Vector2 spawnLocation) {
        if (player != null) {
            PositionComponent pos = player.getComponent(PositionComponent.class);
            
            if (pos != null && pos.getY() < -300) {
                respawnPlayer(player, spawnLocation);
            }
        }
    }

    private static void respawnPlayer(Entity player, Vector2 spawnLocation) {
        if (spawnLocation == null) return;

        System.out.println("MORT ! Respawn en " + spawnLocation);

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

    public static void update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {
        String key = entitySet.getKey();
        Entity entity = entitySet.getValue();

        Rectangle endZone = mapLoader.getEndZone();
        if (endZone != null) {
            if (key == "player1") {
                HitboxComponent hitbox = entity.getComponent(HitboxComponent.class);
                
                if (hitbox != null && hitbox.getBounds().overlaps(endZone)) {
                    System.out.println("Niveau terminé ! Bravo Santa !");
                }
                checkPlayerFall(entity, mapLoader.getPlayerStart());
            }
        }
        
    }
}
