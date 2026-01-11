package com.model.world;

// === Importations ===
// Engine
import com.model.entities.Entity;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.HashMap;

public class GameWorldTest {

    @Test
    public void testGestionEntites() {
        GameWorld world = new GameWorld(null, new HashMap<String, Entity>());
        Entity player = new Entity();

        world.addEntity("player1", player);

        assertThat(world.getEntities().size(), is(1));
        assertThat(world.getEntities().get("player1"), is(player));

        world.removeEntity("player1");

        assertThat(world.getEntities().size(), is(0));
    }

    @Test
    public void testRobustesseSansMap() {
        GameWorld world = new GameWorld(null, null);
        
        assertThat(world.getMapWidth(), is(0));
        
        world.update(0.1f); 
    }
}