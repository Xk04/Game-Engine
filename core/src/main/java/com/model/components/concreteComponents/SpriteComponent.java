package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.g2d.TextureRegion;
// Engine
import com.model.components.Component;
// Java
// ====================

public class SpriteComponent extends Component {
    private String texture;

    private TextureRegion currentRegion;

    // Constructeurs
    public SpriteComponent(String texturePath) {
        this.setTexture(texturePath);
        this.currentRegion = null;
    }

    // GETTERS
    public String getTexturePath() {
        return this.texture;
    }

    public TextureRegion getCurrentRegion() {
        return currentRegion;
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

    public void setCurrentRegion(TextureRegion currentRegion) {
        this.currentRegion = currentRegion;
    }

    // Méthodes

}
