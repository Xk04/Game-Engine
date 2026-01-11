package com;

// === Importations ===
// Engine
import com.controller.GameEngine;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
// Java
// ====================

public class MainTest {

    @Test
    public void testInjectionMoteur() {
        GameEngine fakeEngine = new GameEngine(null, null, null, null);

        Main mainApp = new Main(fakeEngine);

        assertThat(mainApp.getGameEngine(), is(fakeEngine));
    }

    @Test
    public void testCreateSecurise() {

        GameEngine fakeEngine = new GameEngine(null, null, null, null);
        Main mainApp = new Main(fakeEngine);

        mainApp.create();

        assertThat(mainApp.getGameEngine(), is(notNullValue()));
    }
}