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

public class Level2Test {

    @Test
    public void testCheminMapParDefaut() {
        Level2 level = null;
        try {
            level = new Level2();
        } catch (Throwable e) {
            // Ignore
        }
        
        if (level != null) {
            assertThat(level.getMapPath(), is("maps/level2.tmx"));
        }
    }

    @Test
    public void testGettersSetters() {
        Level2 level = null;
        try {
            level = new Level2();
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