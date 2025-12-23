package com.model.factories.caracterFactories;

// === Importations ===
// LibGDX

// Engine
import com.model.entities.Entity;
import com.model.factories.EntityFactory;
import com.model.components.concreteComponents.*;
// Java
// ====================

/** Factory simple pour créer un joueur. */
public class PlayerFactory extends EntityFactory {
    // player params
    private float vx;
    private float vy;
    private String texturePath;
    private int hitboxWidth;
    private int hitboxHeight;

    // Constructeurs
    public PlayerFactory() {
        this.vx = 1;
        this.vy = 1;
        this.texturePath = "textures/ennemies/yeti_idle1.png";
        this.hitboxWidth = 0;
        this.hitboxHeight = 0;
    }

    // GETTERS


    // SETTERS
    
    // Méthodes
    public Entity create(float x, float y) {
        Entity player = new Entity();
        player.addComponent(new PositionComponent(x, y));
        player.addComponent(new VelocityComponent(this.vx, this.vy));
        player.addComponent(new SpriteComponent(this.texturePath));
        player.addComponent(new InputComponent());
        player.addComponent(new HitboxComponent(x, y, this.hitboxWidth, this.hitboxHeight));
        return player;
    }
}
