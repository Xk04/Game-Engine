package com.controller;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

// Engine
import com.model.entities.Player;

// Java
// ====================

public class PlayerController extends InputAdapter {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        // Attenion Qwerty
        switch (keycode) {
            case Keys.LEFT:
            case Keys.A: 
                player.left = true; 
                break;
            case Keys.RIGHT: 
            case Keys.D: 
                player.right = true; 
                break;
            case Keys.SPACE: 
            case Keys.W: 
            case Keys.UP: 
                player.jump(); 
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.LEFT: 
            case Keys.A: 
                player.left = false; 
                break;
            case Keys.RIGHT: 
            case Keys.D: 
                player.right = false; 
                break;
        }
        return true;
    }
}