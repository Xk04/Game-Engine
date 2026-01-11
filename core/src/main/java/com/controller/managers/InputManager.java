package com.controller.managers;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
// Engine
import com.model.entities.Entity;
import com.model.world.GameWorld;
import com.model.components.concreteComponents.InputComponent;
// Java
// ====================



public class InputManager extends InputAdapter {

    private InputComponent inputComponent;


    // Constructeur
    public InputManager(Entity player) {
        this.inputComponent = player.getComponent(InputComponent.class);
        System.out.println("⭢ InputManager: ok");
    }


    // GETTERS
    public InputComponent getInputComponent() {
        return inputComponent;
    }


    // SETTERS
    public void setInputComponent(InputComponent inputComponent) {
        this.inputComponent = inputComponent;
    }


    // Méthodes
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

    public void update(GameWorld world, float dt) {
        /*
        if (inputComponent == null) return;

        Entity player = world.getEntities().get("player1");
        if (player == null) return;

        VelocityComponent velocity = player.getComponent(VelocityComponent.class);
        if (velocity == null) return;
        */
    }
}