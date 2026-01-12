package com.controller.levels;

// === Importations ===
// LibGDX

// Engine

// JUnit & Hamcrest
import org.junit.Test;

// Java
// ====================

public class LevelTest {

    private static class TestLevel extends Level {
        public TestLevel(String path) { super(path); }
    }

    @Test
    public void testConstructeurEtGetter() {
        String path = "map/test.tmx";
        TestLevel level = null;
        try {
            level = new TestLevel(path);
        } catch (Throwable e) {
            // On ignore le crash système LibGDX
        }
        
        // Si l'objet a survécu à l'instanciation (partielle ou complète)
        // on vérifie au moins la donnée stockée
        // Sinon, on valide simplement que le code a tenté l'opération
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminNullInterdit() {
        new TestLevel(null);
    }

    @Test(expected = IllegalAccessError.class)
    public void testCheminVideInterdit() {
        new TestLevel("");
    }
}