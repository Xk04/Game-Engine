package com.model.world;

// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

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
        TiledMap emptyMap = new TiledMap();
        
        MapLoader loader = new MapLoader(emptyMap, null);

        Vector2 spawn = loader.getPlayerStart();

        assertThat(spawn.x, is(100f));
        assertThat(spawn.y, is(300f));
    }

    @Test
    public void testZoneFinInexistante() {
        TiledMap emptyMap = new TiledMap();
        
        MapLoader loader = new MapLoader(emptyMap, null);

        Object endZone = loader.getEndZone();

        assertThat(endZone, is(nullValue()));
    }
    

}