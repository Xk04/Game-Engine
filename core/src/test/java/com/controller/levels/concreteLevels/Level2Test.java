package com.controller.levels.concreteLevels;

// Imports Engine
import com.model.world.GameWorld;
import com.model.entities.Entity;

// Imports JUnit / Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashMap;

public class Level2Test {

    @Test
    public void testCheminMapParDefaut() {
        // GIVEN
        Level2 level = new Level2();

        // THEN
        // On vérifie que le constructeur a bien défini le bon fichier
        assertThat(level.getMapPath(), is("maps/level2.tmx"));
    }

    @Test
    public void testGettersSetters() {
        // GIVEN
        Level2 level = new Level2();
        GameWorld fakeWorld = null; // On met null car on ne peut pas instancier GameWorld sans LibGDX
        HashMap<String, Entity> entities = new HashMap<>();

        // WHEN
        level.setWorld(fakeWorld);
        level.setEntities(entities);

        // THEN
        assertThat(level.getWorld(), is(fakeWorld));
        assertThat(level.getEntities(), is(entities));
    }

    // NOTE : On ne teste pas setUpGameWorld() ici car cela nécessite
    // le moteur graphique LibGDX (Gdx.files) qui n'est pas disponible dans JUnit.
}