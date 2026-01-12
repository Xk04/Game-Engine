package com.model.components.concreteComponents;


// === Importations ===
// LibGDX

// Engine
import com.model.components.Component;
// Java
import java.util.HashMap;
// ====================



public class AnimationComponent extends Component {
    
    private HashMap<Integer, AnimInfo> animations;


    // Constructeur
    public AnimationComponent() {
        this.animations = new HashMap<>();
    }


    // GETTERS
    public HashMap<Integer, AnimInfo> getAnimations() {
        return animations;
    }


    // SETTERS
    public void setAnimations(HashMap<Integer, AnimInfo> animations) {
        this.animations = animations;
    }

    
    // Méthodes
    public void addAnimation(int state, String basePath, int frameCount, float speed) {
        animations.put(state, new AnimInfo(basePath, frameCount, speed));
    }
}