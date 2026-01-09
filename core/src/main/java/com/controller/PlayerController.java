package com.controller;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
// Engine
import com.model.entities.Entity;
import com.model.components.concreteComponents.InputComponent;
// Java
// ====================


public class PlayerController extends InputAdapter {
    
    private InputComponent inputComponent;

    // Constructeur
    public PlayerController(Entity player) {
        this.inputComponent = player.getComponent(InputComponent.class);
    }

    // getter et setter
    public InputComponent getInputComponent() {
        return inputComponent;
    }

    public void setInputComponent(InputComponent inputComponent) {
        this.inputComponent = inputComponent;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (inputComponent != null) {
            switch (keycode) {
                case Keys.LEFT:
                case Keys.Q:
                    inputComponent.setLeft(true);
                    break;
                
                case Keys.RIGHT:
                case Keys.D:
                    inputComponent.setRight(true);
                    break;
                
                case Keys.SPACE:
                case Keys.Z:
                case Keys.UP:
                    inputComponent.setSpace(true);
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (inputComponent != null) {
            switch (keycode) {
                case Keys.LEFT:
                case Keys.Q:
                    inputComponent.setLeft(false);
                    break;
                case Keys.RIGHT:
                case Keys.D:
                    inputComponent.setRight(false);
                    break;
                case Keys.SPACE:
                case Keys.Z:
                case Keys.UP:
                    inputComponent.setSpace(false);
                    break;
            }
        }
        return true;
    }

    
}