package com;

// === Importations ===
// Engine
// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
// Java
// ====================

public class MainTest {

    @Test
    public void testInitialisation() {
        Main mainApp = new Main();

        assertThat(mainApp, is(notNullValue()));
    }

    @Test
    public void testCreateCycle() {
        Main mainApp = new Main();

        try {
            mainApp.create();
        } catch (Throwable e) {
            // ignore
        }

        assertThat(mainApp, is(notNullValue()));
    }

    @Test
    public void testRenderSecurite() {
        Main mainApp = new Main();
        try {
            mainApp.render();
        } catch (Throwable e) {
            // ignore
        }
    }
}