package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// EngineitboxComponent;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class HitboxComponentTest {

    @Test
    public void testConstructeur() {
        float x = 10, y = 20, w = 32, h = 64;

        HitboxComponent hitbox = new HitboxComponent(x, y, w, h);

        assertThat(hitbox.getX(), is(x));
        assertThat(hitbox.getY(), is(y));
        assertThat(hitbox.getWidth(), is(w));
        assertThat(hitbox.getHeight(), is(h));
        
        assertThat(hitbox.getBounds(), is(notNullValue()));
        assertThat(hitbox.getBounds().x, is(x));
    }

    @Test
    public void testSettersIndividuels() {
        HitboxComponent hitbox = new HitboxComponent(0, 0, 10, 10);

        hitbox.setX(50);
        hitbox.setY(100);

        assertThat(hitbox.getX(), is(50f));
        assertThat(hitbox.getY(), is(100f));
        
        assertThat(hitbox.getBounds().x, is(50f));
        assertThat(hitbox.getBounds().y, is(100f));
    }

    @Test
    public void testSetPosition() {
        HitboxComponent hitbox = new HitboxComponent(0, 0, 10, 10);

        hitbox.setPosition(200, 300);

        assertThat(hitbox.getX(), is(200f));
        assertThat(hitbox.getY(), is(300f));
    }

    @Test
    public void testSetBounds() {
        HitboxComponent hitbox = new HitboxComponent(0, 0, 0, 0);

        hitbox.setBounds(10, 10, 50, 50);

        assertThat(hitbox.getX(), is(10f));
        assertThat(hitbox.getWidth(), is(50f));
    }
}