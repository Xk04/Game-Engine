package com.model.factories;

// === Importations ===
// LibGDX

// Engine
import com.model.entities.Entity;

// Java
// ====================

public abstract class EntityFactory {
    public abstract Entity create(float x, float y);
}
