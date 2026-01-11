package com.controller.inputs;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
// Engine
import com.model.entities.Entity;
import com.model.components.concreteComponents.InputComponent;
// Java
// ====================


public class InputManager extends InputAdapter {

    private InputComponent inputComponent;

    // Constructeur
    public InputManager(Entity player) {
        this.inputComponent = player.getComponent(InputComponent.class);
    }

    // GETTERS
    public InputComponent getInputComponent() {
        return inputComponent;
    }

    // GETTERS
    public void setInputComponent(InputComponent inputComponent) {
        this.inputComponent = inputComponent;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (inputComponent == null)
            return false;

        switch (keycode) {
            case Keys.LEFT:
            case Keys.Q: // Support AZERTY
            case Keys.A: // Support QWERTY
                inputComponent.setLeft(true);
                break;
            case Keys.RIGHT:
            case Keys.D:
                inputComponent.setRight(true);
                break;
            case Keys.SPACE:
            case Keys.UP:
            case Keys.Z:
            case Keys.W:
                inputComponent.setSpace(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (inputComponent == null)
            return false;

        switch (keycode) {
            case Keys.LEFT:
            case Keys.Q:
            case Keys.A:
                inputComponent.setLeft(false);
                break;
            case Keys.RIGHT:
            case Keys.D:
                inputComponent.setRight(false);
                break;
            case Keys.SPACE:
            case Keys.UP:
            case Keys.Z:
            case Keys.W:
                inputComponent.setSpace(false);
                break;
        }
        return true;
    }

}