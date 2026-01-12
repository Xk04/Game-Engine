package com.model.components.concreteComponents;

// === Importations ===
// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class SpriteComponentTest {

    @Test
    public void testCheminValide() {
        String chemin = "player/idle.png";

        SpriteComponent sprite = new SpriteComponent(chemin);

        assertThat(sprite.getTexturePath(), is(chemin));
    }

    @Test
    public void testMiseAJourChemin() {
        SpriteComponent sprite = new SpriteComponent("start.png");

        sprite.setTexture("end.png");

        assertThat(sprite.getTexturePath(), is("end.png"));
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminVideInterdit() {
        new SpriteComponent("");
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminNullInterdit() {
        new SpriteComponent(null);
    }
}