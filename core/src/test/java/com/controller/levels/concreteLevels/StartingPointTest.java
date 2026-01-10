package com.controller.levels.concreteLevels;

// === Importations ===
// LibGDX

// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class StartingPointTest {

    @Test
    public void testCheminMapStartingPoint() {
        StartingPoint level = new StartingPoint();

        assertThat(level.getMapPath(), containsString("level0.tmx"));
    }
}