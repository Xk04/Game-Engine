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
 * Les entités sont mises à jour par les systèmes du jeu.
 */
public class Entity {

    private LinkedList<Component> components;

    
    // Constructeurs
    /** Crée une entité à partir d'une liste de composants. */
    public Entity() {
        this.setComponents(null);
    }


    // GETTERS
    /** Retourne le composant associé ou null (dans le cas où il n'existe pas). */
    public <T extends Component> T getComponent(Class<T>  componentClass) {
        for (Component actualComponent : this.components) {
            if (actualComponent.getClass() == componentClass)  {
                return componentClass.cast(actualComponent);
            }
        }
        return null;
    }


    // SETTERS
    /** Remplace la liste des composants (copie des éléments). */
    public void setComponents(LinkedList<Component> componentsList) {
        this.components = new LinkedList<>();
        if (componentsList != null) {
            for (Component component : componentsList) {
                this.components.add(component);
            }
        }
    }

    public void addComponent(Component newComponent) {
        this.components.add(newComponent);
    }


    // Méthodes
}