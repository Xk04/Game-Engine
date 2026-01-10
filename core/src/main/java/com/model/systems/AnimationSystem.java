package com.model.systems;

// === Importations ===
// LibGDX

// Engine
import com.model.components.concreteComponents.AnimInfo;
import com.model.components.concreteComponents.AnimationComponent;
import com.model.components.concreteComponents.SpriteComponent;
import com.model.components.concreteComponents.StateComponent;
import com.model.entities.Entity;
// Java
import java.util.HashMap;
import java.util.Map;
// ====================


public class AnimationSystem {
    public static void update(Map.Entry<String, Entity> entitySet, float deltaTime) {
        Entity entity = entitySet.getValue();
        
        StateComponent state = entity.getComponent(StateComponent.class);
        SpriteComponent sprite = entity.getComponent(SpriteComponent.class);

        if (state == null || sprite == null) return;

        state.stateTime += deltaTime;
        HashMap<Integer, AnimInfo> animations = entity.getComponent(AnimationComponent.class).getAnimations();
        AnimInfo currentAnim = animations.get(state.getEtatCourant());

        if (currentAnim != null) {
            
            int frameIndex = (int)(state.stateTime / currentAnim.getSpeed()) % currentAnim.getCount();
            int fileIndex = frameIndex + 1;

            String newPath = currentAnim.getPath() + "_" + fileIndex + ".png";

            sprite.setTexture(newPath);
        }
    }
}
