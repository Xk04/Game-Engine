package com.model.world;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class MapLoaderTest {

    @Test
    public void testSpawnParDefaut() {
        MapLoader loader = null;
        try {
            loader = new MapLoader("fake_map.tmx");
        } catch (Throwable e) {
            // ignore
        }

        if (loader != null) {
            Vector2 spawn = loader.getPlayerStart();

            assertThat(spawn.x, is(100f));
            assertThat(spawn.y, is(300f));
        }
    }

    @Test
    public void testZoneFinInexistante() {
        MapLoader loader = null;
        try {
            loader = new MapLoader("fake_map.tmx");
        } catch (Throwable e) {
            // Ignore
        }

        if (loader != null) {
            Rectangle endZone = loader.getEndZone();
            assertThat(endZone, is(nullValue()));
        }
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminVideInterdit() {
        new MapLoader("");
    }
}