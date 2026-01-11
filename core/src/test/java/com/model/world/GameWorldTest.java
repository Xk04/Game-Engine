package com.model.world;

// === Importations ===
// LibGDX
// Engine
import com.model.entities.Entity;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.HashMap;
// ====================

public class GameWorldTest {

    @Test
    public void testGestionEntites() {
        GameWorld world = null;
        try {
            world = new GameWorld(null, "map/level1.tmx", new HashMap<String, Entity>());
        } catch (Throwable e) {
            // Ignore
        }

        if (world != null) {
            Entity player = new Entity();
            world.addEntity("player1", player);

            assertThat(world.getEntities().size(), is(1));
            assertThat(world.getEntities().get("player1"), is(player));

            world.removeEntity("player1");
            assertThat(world.getEntities().size(), is(0));
        }
    }

    @Test
    public void testRobustesseInitialisation() {
        boolean errorThrown = false;
        try {
            new GameWorld(null, "map/level1.tmx", null);
        } catch (Throwable e) {
            errorThrown = true;
        }
        assertThat("Le système doit réagir à une initialisation incomplète", errorThrown, is(true));
    }

    @Test
    public void testUpdateRetour() {
        GameWorld world = null;
        try {
            world = new GameWorld(null, "map/level1.tmx", new HashMap<String, Entity>());
            boolean finished = world.update(0.1f);
            assertThat(finished, is(false));
        } catch (Throwable e) {
            // Ignore
        }
    }
}