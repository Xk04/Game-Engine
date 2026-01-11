package com.model.factories.caracterFactories;

// === Importations ===
// LibGDX

// Engine
import com.model.entities.Entity;
import com.model.factories.EntityFactory;
import com.model.components.concreteComponents.*;
// Java
// ====================


/** Factory simple pour créer un joueur. 
  * 
  */
public class PlayerFactory extends EntityFactory {

    // Constructeurs
    public PlayerFactory() {

    }

    // GETTERS

    // SETTERS
    
    // Méthodes
    @Override
    public Entity create(float x, float y) {
        Entity player = new Entity();
        player.addComponent(new PositionComponent(x, y));
        player.addComponent(new VelocityComponent(0, 0));
        player.addComponent(new InputComponent());
        player.addComponent(new HitboxComponent(x, y,30,60));
        player.addComponent(new StateComponent());
        player.addComponent(new PhysicsComponent());
        AnimationComponent anims = new AnimationComponent();

        // Chargement des fichiers d'animation
        anims.addAnimation(StateComponent.IDLE, "textures/player/santa_idle", 16, 0.1f);
        anims.addAnimation(StateComponent.RUN, "textures/player/santa_run", 11, 0.05f);
        anims.addAnimation(StateComponent.JUMP, "textures/player/santa_jump", 16, 0.05f);
        anims.addAnimation(StateComponent.SLIDE, "textures/player/santa_slide", 11, 0.1f);
        anims.addAnimation(StateComponent.WALK, "textures/player/santa_walk", 13, 0.1f);
        anims.addAnimation(StateComponent.DEAD, "textures/player/santa_dead", 17, 0.1f);
        player.addComponent(anims);
        player.addComponent(new SpriteComponent("textures/player/santa_idle_1.png"));

        return player;
    }
}