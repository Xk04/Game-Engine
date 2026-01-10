package com.controller;

// === Importations ===
// LibGDX
// Engine
import com.controller.inputs.InputManager;
import com.controller.levels.LevelManager;
import com.model.world.GameWorld;
import com.view.screens.GameScreen;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class GameEngineTest {

    @Test
    public void testInjectionDependances() {
        LevelManager fakeLevelManager = null;
        GameWorld fakeGameWorld = null; 
        InputManager fakeInputManager = null;
        GameScreen fakeGameScreen = null;

        GameEngine engine = new GameEngine(fakeLevelManager, fakeGameWorld, fakeInputManager, fakeGameScreen);

        assertThat(engine.getLevelManager(), is(fakeLevelManager));
        assertThat(engine.getGameWorld(), is(fakeGameWorld));
        assertThat(engine.getInputManager(), is(fakeInputManager));
    }

    @Test
    public void testSetters() {
        GameEngine engine = new GameEngine(null, null, null, null);
        
        LevelManager nouveauManager = new LevelManager(); 

        engine.setLevelManager(nouveauManager);

        assertThat(engine.getLevelManager(), is(nouveauManager));
    }
    
}