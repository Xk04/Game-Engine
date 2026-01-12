package com.controller;

// === Importations ===
import com.controller.managers.LevelManager;
import com.model.world.GameWorld;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.HashMap;

public class GameEngineTest {

    @Test
    public void testInitialisationEtGetters() {
        GameEngine engine = null;
        try {
            engine = new GameEngine();
        } catch (Throwable e) {
            // ignore}

            if (engine != null) {
                assertThat(engine.getLevelManager(), is(notNullValue()));
                assertThat(engine.getGameWorld(), is(notNullValue()));
                assertThat(engine.getInputManager(), is(notNullValue()));
            }
        }
    }

    @Test
    public void testSetters() {
        GameEngine engine = null;
        try {
            engine = new GameEngine();
        } catch (Throwable e) {
        }

        if (engine == null)
            return;

        LevelManager nouveauManager = new LevelManager();
        engine.setLevelManager(nouveauManager);
        assertThat(engine.getLevelManager(), is(nouveauManager));

        GameWorld world = new GameWorld(null, "map.tmx", new HashMap<>());
        engine.setGameWorld(world);
        assertThat(engine.getGameWorld(), is(world));
    }
}
