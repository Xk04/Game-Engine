package com.controller.inputs;


// === Importations ===
// Imports LibGDX
import com.badlogic.gdx.Input;

// Imports Engine
import com.model.components.concreteComponents.InputComponent;
import com.model.entities.Entity;

// Imports JUnit / Hamcrest
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
// ====================


public class InputManagerTest {

    private InputManager inputManager;
    private InputComponent inputComponent;

    @Before
    public void setUp() {
        inputComponent = new InputComponent();
        Entity player = new Entity();
        player.addComponent(inputComponent);

        inputManager = new InputManager(player);
    }

    @Test
    public void testDeplacementGauche() {
        inputManager.keyDown(Input.Keys.Q);
        assertThat("Q doit activer la gauche", inputComponent.isLeft(), is(true));

        inputManager.keyDown(Input.Keys.LEFT);
        assertThat("LEFT doit activer la gauche", inputComponent.isLeft(), is(true));
        
        inputManager.keyUp(Input.Keys.Q);
        assertThat("Relâcher Q doit désactiver la gauche", inputComponent.isLeft(), is(false));
    }

    @Test
    public void testDeplacementDroite() {
        inputManager.keyDown(Input.Keys.D);
        assertThat("D doit activer la droite", inputComponent.isRight(), is(true));

        inputManager.keyUp(Input.Keys.D);
        assertThat("Relâcher D doit désactiver la droite", inputComponent.isRight(), is(false));
    }

    @Test
    public void testSaut() {
        inputManager.keyDown(Input.Keys.SPACE);
        assertThat("Espace doit activer le saut", inputComponent.isSpace(), is(true));

        inputManager.keyDown(Input.Keys.Z);
        assertThat("Z doit activer le saut", inputComponent.isSpace(), is(true));

        inputManager.keyUp(Input.Keys.SPACE);
        assertThat("Relâcher Espace doit désactiver le saut", inputComponent.isSpace(), is(false));
    }

    @Test
    public void testToucheInconnueIgnoree() {
        inputManager.keyDown(Input.Keys.K);

        assertThat(inputComponent.isLeft(), is(false));
        assertThat(inputComponent.isRight(), is(false));
        assertThat(inputComponent.isSpace(), is(false));
    }

    @Test
    public void testRobustesseSansComposant() {
        Entity emptyEntity = new Entity();
        InputManager managerVide = new InputManager(emptyEntity);

        boolean handled = managerVide.keyDown(Input.Keys.SPACE);
        
        assertThat(handled, is(false));
    }
}