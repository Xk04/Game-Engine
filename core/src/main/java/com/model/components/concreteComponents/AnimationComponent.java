package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

// Engine
import com.model.components.Component;
import com.model.entities.Entity;
// Java
import java.util.HashMap;
// ====================

public class AnimationComponent extends Component {
    
    private static class AnimInfo {
        String path;
        int count;
        float speed;
        
        public AnimInfo(String path, int count, float speed) {
            this.path = path;
            this.count = count;
            this.speed = speed;
        }
    }
    //public HashMap<Integer, Animation<TextureRegion>> animations;
    private HashMap<Integer, AnimInfo> animations;

    // Constructeur
    public AnimationComponent() {
        this.animations = new HashMap<>();
    }

    // Méthodes
    /*public void addAnimation(int stateKey, String path, int frameCount, float duration) {
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
    }*/
   public void addAnimation(int state, String basePath, int frameCount, float speed) {
        animations.put(state, new AnimInfo(basePath, frameCount, speed));
    }

    public void update(Entity entity, float deltaTime) {
        StateComponent state = entity.getComponent(StateComponent.class);
        SpriteComponent sprite = entity.getComponent(SpriteComponent.class);

        if (state == null || sprite == null) return;

        state.stateTime += deltaTime;

        AnimInfo currentAnim = animations.get(state.getEtatCourant());

        if (currentAnim != null) {
            
            int frameIndex = (int)(state.stateTime / currentAnim.speed) % currentAnim.count;
            int fileIndex = frameIndex + 1;

            String newPath = currentAnim.path + "_" + fileIndex + ".png";

            sprite.setTexturePath(newPath);
        }
    }
    // Pour récupérer l'animation
    /*public Animation<TextureRegion> get(int stateKey) {
        return animations.get(stateKey);
    }*/
}
