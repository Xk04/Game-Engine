package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
// Java
// ====================


public class AnimInfo {
    private String path;
    private int count;
    private float speed;

    // Constructeurs
    public AnimInfo(String path, int count, float speed) {
        this.path = path;
        this.count = count;
        this.speed = speed;
    }
        
    // GETTERS
    public String getPath() {
        return path;
    }

    public float getSpeed() {
        return speed;
    }

    public int getCount() {
        return count;
    }

    // SETTERS
    public void setCount(int count) {
        this.count = count;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}