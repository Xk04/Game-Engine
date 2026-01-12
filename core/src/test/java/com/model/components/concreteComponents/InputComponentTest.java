package com.model.components.concreteComponents;

// === Importations ===
// EngineInputComponent;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class InputComponentTest {

    @Test
    public void testValeursParDefaut() {
        InputComponent inputs = new InputComponent();

        assertThat("Up doit être false", inputs.isUp(), is(false));
        assertThat("Down doit être false", inputs.isDown(), is(false));
        assertThat("Left doit être false", inputs.isLeft(), is(false));
        assertThat("Right doit être false", inputs.isRight(), is(false));
        assertThat("Space doit être false", inputs.isSpace(), is(false));
    }

    @Test
    public void testChangementEtat() {
        InputComponent inputs = new InputComponent();

        inputs.setLeft(true);
        inputs.setSpace(true);

        assertThat(inputs.isLeft(), is(true));
        assertThat(inputs.isSpace(), is(true));
        
        assertThat(inputs.isRight(), is(false));
    }

    @Test
    public void testResetEtat() {
        InputComponent inputs = new InputComponent();
        inputs.setRight(true);

        inputs.setRight(false);

        assertThat(inputs.isRight(), is(false));
    }
}