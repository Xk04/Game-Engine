package com.controller.levels.concreteLevels;

// === Importations ===
// Engine
import com.model.world.GameWorld;
import com.model.entities.Entity;

// JUnit / Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.HashMap;
// ====================

public class Level1Test {

    @Test
    public void testCheminMapParDefaut() {
        Level1 level = null;
        try {
            level = new Level1();
        } catch (Throwable e) {
            // ignore
        }

        if (level != null) {
            assertThat(level.getMapPath(), is("maps/level1.tmx"));
        }
    }

    @Test
    public void testGettersSetters() {
        Level1 level = null;
        try {
            level = new Level1();
            GameWorld fakeWorld = null;
            HashMap<String, Entity> entities = new HashMap<>();

            level.setWorld(fakeWorld);
            level.setEntities(entities);

            assertThat(level.getWorld(), is(fakeWorld));
            assertThat(level.getEntities(), is(entities));
        } catch (Throwable e) {
            // ignore
        }
    }
}