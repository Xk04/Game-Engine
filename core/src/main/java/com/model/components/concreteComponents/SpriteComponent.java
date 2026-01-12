package com.model.components.concreteComponents;


// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================



public class SpriteComponent extends Component {
    private String texture;


    // Constructeurs
    public SpriteComponent(String texturePath) {
        this.setTexture(texturePath);
    }


    // GETTERS
    public String getTexturePath() {
        return this.texture;
    }


    // SETTERS
    public void setTexture(String texturePath) {
        if (texturePath == "") {
            throw new IllegalAccessError("\n> Impossible de charger une texture vide !");
        } else if (texturePath == null) {
            throw new IllegalAccessError("\n> Impossible de charger une texture \"null\" !");
        } else {
            this.texture = texturePath;
        }
    }

    
    // Méthodes
}
