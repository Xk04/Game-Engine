package com.model.entities;

import java.util.LinkedList;
import com.model.components.Component;

public class Entity {
    private LinkedList<Component> components;

    // Constructeurs
    public Entity(LinkedList<Component> componentsList) {
        this.components = new LinkedList<>();
        for (Component component : componentsList) {
            this.components.add(component);
        }
    }

    // GETTERS
    public LinkedList<Component> getComponents() {
        return this.components;
    }

    // SETTERS

    // Méthodes
}
