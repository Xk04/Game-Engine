package com.model.components.concreteComponents;

// === Importations ===
// LibGDX

// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class AnimInfoTest {

    @Test
    public void testConstructeurEtGetters() {
        String chemin = "player/run.png";
        int nombreImages = 8;
        float vitesse = 0.15f;

        AnimInfo info = new AnimInfo(chemin, nombreImages, vitesse);

        assertThat(info.getPath(), is(chemin));
        assertThat(info.getCount(), is(nombreImages));
        assertThat(info.getSpeed(), is(vitesse));
    }

    @Test
    public void testSetters() {
        AnimInfo info = new AnimInfo("old.png", 1, 1.0f);

        info.setPath("new.png");
        info.setCount(12);
        info.setSpeed(0.5f);

        assertThat(info.getPath(), is("new.png"));
        assertThat(info.getCount(), is(12));
        assertThat(info.getSpeed(), is(0.5f));
    }
}