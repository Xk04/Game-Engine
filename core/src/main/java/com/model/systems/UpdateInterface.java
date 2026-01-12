package com.model.systems;


// === Importations ===
// LibGDX
// Engine
import com.model.entities.Entity;
import com.model.world.MapLoader;
// Java
import java.util.Map;
// ====================



/**
 * Interface pour les systèmes de mise à jour des entités.
 * <p>
 * Les classes implémentant cette interface doivent fournir une méthode
 * statique {@link #update(MapLoader, Map.Entry, float)} pour mettre à jour
 * les entités dans le contexte du monde du jeu.
 */
public interface UpdateInterface {
    
    /**
     * Updates the entity in the game world context.
     * @param mapLoader the map loader
     * @param entitySet the entity entry
     * @param deltaTime the time delta
     * @return true if update successful, false otherwise
     */
    public static boolean update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) { return false; }
}
