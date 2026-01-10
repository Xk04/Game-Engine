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
        
        assertThat(pos.getPos()[0], is(x));
        assertThat(pos.getPos()[1], is(y));
    }

    @Test
    public void testSettersIndividuels() {
        PositionComponent pos = new PositionComponent(0, 0);

        pos.setX(10f);
        pos.setY(20f);

        assertThat(pos.getX(), is(10f));
        assertThat(pos.getY(), is(20f));
    }

    @Test
    public void testSetPos() {
        PositionComponent pos = new PositionComponent(0, 0);

        pos.setPos(5f, 5f);

        float[] tableau = pos.getPos();
        assertThat(tableau[0], is(5f));
        assertThat(tableau[1], is(5f));
    }
}