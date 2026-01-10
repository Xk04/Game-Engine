package com.controller.levels;

// === Importations ===
// LibGDX

// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class LevelTest {

    /**
     * Classe interne "Stub" (Bouchon) concrète.
     * Elle sert uniquement à pouvoir instancier la classe abstraite Level pour les tests.
     */
    private static class TestLevel extends Level {
        public TestLevel(String path) {
            super(path);
        }
    }

    @Test
    public void testConstructeurEtGetter() {
        String chemin = "maps/test.tmx";
        
        Level level = new TestLevel(chemin);

        assertThat(level.getMapPath(), is(chemin));
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminVideInterdit() {
        new TestLevel("");
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminNullInterdit() {
        new TestLevel(null);
    }

    
}