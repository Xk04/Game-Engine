package com.model.entities;

// === Importations ===
// LibGDX

// Engine
import java.util.LinkedList;
import com.model.components.Component;

// Java
// ====================


/**
 * Entité de jeu de base. Contient une collection de {@link com.model.components.Component}.
 * <p>
 * Les entités doivent définir leur comportement dans {@link #update(float)}.
 */
public abstract class Entity {
    private LinkedList<Component> components;

    // Constructeurs
    /** Crée une entité à partir d'une liste de composants. */
    public Entity(LinkedList<Component> componentsList) {
        this.setComponents(componentsList);
    }

    // GETTERS
    /** Retourne la liste des composants attachés à l'entité. */
    public LinkedList<Component> getComponents() {
        return this.components;
    }

    // SETTERS
    /** Remplace la liste des composants (copie des éléments). */
    public void setComponents(LinkedList<Component> componentsList) {
        this.components = new LinkedList<>();
        for (Component component : componentsList) {
            this.components.add(component);
        }
    }

    // Méthodes
    /** Méthode appelée chaque frame pour mettre à jour l'entité. */
    public void update(float deltaTime) {
        
    }
}
