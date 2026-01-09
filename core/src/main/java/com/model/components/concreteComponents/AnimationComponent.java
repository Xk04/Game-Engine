package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

// Engine
import com.model.components.Component;

// Java
import java.util.HashMap;
// ====================

public class AnimationComponent extends Component {
    public HashMap<Integer, Animation<TextureRegion>> animations;

    // Constructeur
    public AnimationComponent() {
        this.animations = new HashMap<>();
    }

    // Méthodes
    public void addAnimation(int stateKey, String path, int frameCount, float duration) {
        Array<TextureRegion> frames = new Array<>();

        for (int i = 1; i <= frameCount; i++) {
            try {
                Texture fullPath = new Texture(path + "_" + i + ".png");
                frames.add(new TextureRegion(fullPath));
            } catch (Exception e) {
                System.err.println("ERREUR : Impossible de charger l'image " + path + "_" + i + ".png");
            }
        }

        if (frames.size > 0) {
            Animation<TextureRegion> anim = new Animation<>(duration, frames);
            this.animations.put(stateKey, anim);
            System.out.println("Animation ajoutée pour l'état " + stateKey + " avec " + frameCount + " images.");
        } else {
            System.err.println("ERREUR : Aucune image chargée pour l'animation de l'état " + stateKey);
        }
    }

    // Pour récupérer l'animation
    public Animation<TextureRegion> get(int stateKey) {
        return animations.get(stateKey);
    }
}
