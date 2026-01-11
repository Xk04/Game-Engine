package com.model.systems;


// === Importations ===
// LibGDX
// Engine
import com.model.entities.Entity;
import com.model.world.MapLoader;
// Java
import java.util.Map;
// ====================



public interface UpdateInterface {
    public static void update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {}
}
