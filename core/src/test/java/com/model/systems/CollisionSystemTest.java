package com.model.systems;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

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

    // fausse classe MapLoader pour le test
    // Cela évite d'avoir besoin d'un fichier .tmx réel
    private static class MockMapLoader extends MapLoader {
        public MockMapLoader() {
            super(null, null); 
        }

        @Override
        public Vector2 getPlayerStart() {
            return new Vector2(100, 300); 
        }

        @Override
        public Rectangle getEndZone() {
            return new Rectangle(500, 300, 50, 50);
        }
    }

    @Test
    public void testRespawnApresChute() {
        Entity player = new Entity();

        PositionComponent pos = new PositionComponent(50, -400);
        player.addComponent(pos);

        VelocityComponent vel = new VelocityComponent(0, -500);
        player.addComponent(vel);

        HitboxComponent hit = new HitboxComponent(50, -400, 32, 32);
        player.addComponent(hit);

        MockMapLoader loader = new MockMapLoader();
        HashMap<String, Entity> map = new HashMap<>();
        map.put("player1", player);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        CollisionSystem.update(loader, entry, 0.1f);

        assertThat(pos.getX(), is(100f));
        assertThat(pos.getY(), is(300f));

        assertThat(vel.getVX(), is(0f));
        assertThat(vel.getVY(), is(0f));

        assertThat(hit.getX(), is(100f));
        assertThat(hit.getY(), is(300f));
    }

    @Test
    public void testPasDeRespawnSiEnSecurite() {
        Entity player = new Entity();
        PositionComponent pos = new PositionComponent(50, 0);
        player.addComponent(pos);

        MockMapLoader loader = new MockMapLoader();
        HashMap<String, Entity> map = new HashMap<>();
        map.put("player1", player);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        CollisionSystem.update(loader, entry, 0.1f);

        assertThat(pos.getY(), is(0f));
    }
}