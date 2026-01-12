package com.model.systems;


// === Importations ===
// LibGDX
// Engine
import com.model.components.concreteComponents.AnimInfo;
import com.model.components.concreteComponents.AnimationComponent;
import com.model.components.concreteComponents.SpriteComponent;
import com.model.components.concreteComponents.StateComponent;
import com.model.entities.Entity;
import com.model.world.MapLoader;
// Java
import java.util.HashMap;
import java.util.Map;
// ====================



/**
 * Système de gestion des animations des entités.
 * <p>
 * Ce système met à jour les composants d'animation en fonction de l'état
 * des entités et gère les sprites correspondants.
 */
public class AnimationSystem implements UpdateInterface {
    
    // Méthodes
    /**
     * Updates the animation for the given entity.
     * @param mapLoader the map loader
     * @param entitySet the entity entry
     * @param deltaTime the time delta
     * @return false (animation update doesn't trigger level completion)
     */
    public static boolean update(MapLoader mapLoader, Map.Entry<String, Entity> entitySet, float deltaTime) {
        Entity entity = entitySet.getValue();
        
        StateComponent state = entity.getComponent(StateComponent.class);
        SpriteComponent sprite = entity.getComponent(SpriteComponent.class);

        if (state == null || sprite == null) return false;

        state.stateTime += deltaTime;
        HashMap<Integer, AnimInfo> animations = entity.getComponent(AnimationComponent.class).getAnimations();
        AnimInfo currentAnim = animations.get(state.getEtatCourant());

        if (currentAnim != null) {        
            int frameIndex = (int)(state.stateTime / currentAnim.getSpeed()) % currentAnim.getCount();
            int fileIndex = frameIndex + 1;
            String newPath = currentAnim.getPath() + "_" + fileIndex + ".png";
            sprite.setTexture(newPath);
        }
        return false;
    }
}