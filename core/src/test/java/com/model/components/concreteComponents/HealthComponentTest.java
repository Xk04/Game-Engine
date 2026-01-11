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

public class HealthComponentTest {

    @Test
    public void testConstructeur() {
        int min = 0;
        int max = 100;

        HealthComponent health = new HealthComponent(min, max);

        assertThat(health.getMinHealth(), is(min));
        assertThat(health.getMaxHealth(), is(max));
        
        assertThat("Attention: La santé actuelle démarre à 0", health.getCurrentHealth(), is(0));
    }

    @Test
    public void testSetters() {
        HealthComponent health = new HealthComponent(0, 100);

        health.setCurrentHealth(50);
        health.setMinHealth(10);
        health.setMaxHealth(200);

        assertThat(health.getCurrentHealth(), is(50));
        assertThat(health.getMinHealth(), is(10));
        assertThat(health.getMaxHealth(), is(200));
    }
}