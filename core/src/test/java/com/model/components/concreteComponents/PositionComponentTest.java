package com.model.components.concreteComponents;

// === Importations ===
// Engine
// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class PositionComponentTest {

    @Test
    public void testConstructeur() {
        float x = 50f;
        float y = 100f;

        PositionComponent pos = new PositionComponent(x, y);

        assertThat(pos.getX(), is(x));
        assertThat(pos.getY(), is(y));
    }

    @Test
    public void testSettersIndividuels() {
        PositionComponent pos = new PositionComponent(0f, 0f);

        pos.setX(10f);
        pos.setY(20f);

        assertThat(pos.getX(), is(10f));
        assertThat(pos.getY(), is(20f));
    }

    @Test
    public void testCoordonneesNegatives() {
        PositionComponent pos = new PositionComponent(-50f, -10.5f);

        assertThat(pos.getX(), is(-50f));
        assertThat(pos.getY(), is(-10.5f));
    }
}