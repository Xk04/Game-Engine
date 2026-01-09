package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================

public class SpriteComponent extends Component {
    private String texturePath;

    // Constructeurs
    public SpriteComponent(String texturePath) {
        this.setTexturePath(texturePath);
    }

    // GETTERS
    public String getTexturePath() {
        return this.texturePath;
    }

    // SETTERS
    public void setTexturePath(String texturePath) {
        if (texturePath == "") {
            throw new IllegalAccessError("\n> Impossible de charger une texture vide !");
        } else if (texturePath == null) {
            throw new IllegalAccessError("\n> Impossible de charger une texture \"null\" !");
        } else {
            this.texturePath = texturePath;
        }
    }

    // Méthodes
}
