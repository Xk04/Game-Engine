package com.model.factories;


// === Importations ===
// LibGDX
// Engine
import com.model.entities.Entity;
// Java
// ====================



/**
 * Fabrique abstraite pour créer des entités du jeu.
 * <p>
 * Les sous-classes concrètes implémentent la méthode {@link #create(float, float)}
 * pour instancier des entités spécifiques à des positions données.
 */
public abstract class EntityFactory {
    
    public abstract Entity create(float x, float y);
}
