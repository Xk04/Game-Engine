package com.model.systems;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.tiled.TiledMap;

// Engine
import com.model.entities.Entity;
import com.model.world.MapLoader;
import com.model.components.concreteComponents.HitboxComponent;
import com.model.components.concreteComponents.PositionComponent;
import com.model.components.concreteComponents.VelocityComponent;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.HashMap;
import java.util.Map;
// ====================

public class CollisionSystemTest {

    private static class MockMapLoader extends MapLoader {
        public MockMapLoader() {
            super("test/mock.tmx");
        }

        @Override
        public Vector2 getPlayerStart() {
            return new Vector2(100, 300);
        }

        @Override
        public Rectangle getEndZone() {
            return new Rectangle(500, 300, 50, 50);
        }

        @Override
        public TiledMap loadMap(String p) {
            return null;
        }
    }

    @Test
    public void testRespawnApresChute() {
        Entity player = new Entity();
        PositionComponent pos = new PositionComponent(50, -400); // En dessous de -300
        VelocityComponent vel = new VelocityComponent(0, -500);
        HitboxComponent hit = new HitboxComponent(50, -400, 32, 32);

        player.addComponent(pos);
        player.addComponent(vel);
        player.addComponent(hit);

        MockMapLoader loader = new MockMapLoader();
        Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
            {
                put("player1", player);
            }
        }.entrySet().iterator().next();

        CollisionSystem.update(loader, entry, 0.1f);

        assertThat(pos.getX(), is(100f));
        assertThat(pos.getY(), is(300f));
        assertThat(vel.getVX(), is(0f));
    }

    @Test
    public void testDetectionVictoire() {
        Entity player = new Entity();
        player.addComponent(new HitboxComponent(505, 305, 32, 32));

        MockMapLoader loader = new MockMapLoader();
        Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
            {
                put("player1", player);
            }
        }.entrySet().iterator().next();

        boolean result = CollisionSystem.update(loader, entry, 0.1f);
        assertThat("Le système doit détecter la victoire", result, is(true));
    }
}