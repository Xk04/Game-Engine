package com.controller.levels;

// === Importations ===
// LibGDX

// Engine
import com.controller.levels.concreteLevels.Level1;
import com.controller.levels.concreteLevels.Level2;
import com.controller.levels.concreteLevels.StartingPoint;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class LevelManagerTest {

    @Test
    public void testInitialisationListeNiveaux() {
        LevelManager manager = new LevelManager();

        assertThat("La liste doit contenir 3 niveaux", manager.getLevels().size(), is(3));

        assertThat(manager.getLevels().get(0), instanceOf(StartingPoint.class));
        
        assertThat(manager.getLevels().get(1), instanceOf(Level1.class));
        
        assertThat(manager.getLevels().get(2), instanceOf(Level2.class));
    }

    @Test
    public void testNiveauCourantAuDemarrage() {
        LevelManager manager = new LevelManager();

        assertThat(manager.getCurrentLevel(), instanceOf(StartingPoint.class));
    }

    @Test
    public void testNavigationIterator() {
        LevelManager manager = new LevelManager();

        assertThat("Doit avoir un niveau suivant", manager.hasNextLevel(), is(true));
        
    }
}