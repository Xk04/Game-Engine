    package com.model.components.concreteComponents;

// === Importations ===
// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class PhysicsComponentTest {

    @Test
    public void testValeursParDefaut() {
        PhysicsComponent physics = new PhysicsComponent();

        assertThat("Vitesse par défaut incorrecte", physics.getMoveSpeed(), is(180f));
        assertThat("Force de saut par défaut incorrecte", physics.getJumpForce(), is(400f));
        assertThat("Gravité par défaut incorrecte", physics.getGravity(), is(-1000f));
        assertThat("Ne doit pas être au sol au début", physics.isIsGrounded(), is(false));
    }

    @Test
    public void testModificationPhysique() {
        PhysicsComponent physics = new PhysicsComponent();

        physics.setMoveSpeed(250f);
        physics.setJumpForce(600f);
        physics.setGravity(-500f);
        physics.setIsGrounded(true);

        assertThat(physics.getMoveSpeed(), is(250f));
        assertThat(physics.getJumpForce(), is(600f));
        assertThat(physics.getGravity(), is(-500f));
        assertThat(physics.isIsGrounded(), is(true));
    }
}