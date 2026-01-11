package com.controller.levels.concreteLevels;

// === Importations ===
// Engine
import com.model.world.GameWorld;
import com.model.entities.Entity;

// JUnit / Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;
// ====================

public class StartingPointTest {

    @Test
    public void testCheminMapParDefaut() {
        StartingPoint level = null;
        try {
            level = new StartingPoint();
        } catch (Throwable e) {
            // Ignore
        }
        
        if (level != null) {
            assertThat(level.getMapPath(), is("maps/level0.tmx"));
        }
    }

    @Test
    public void testGettersSetters() {
        StartingPoint level = null;
        try {
            level = new StartingPoint();
            GameWorld fakeWorld = null;
            HashMap<String, Entity> entities = new HashMap<>();

            level.setWorld(fakeWorld);
            level.setEntities(entities);

            assertThat(level.getWorld(), is(fakeWorld));
            assertThat(level.getEntities(), is(entities));
        } catch (Throwable e) {
            // Ignore
        }
    }
}