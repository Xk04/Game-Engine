package com.model.factories.caracterFactories;

// === Importations ===
// LibGDX

// Engine
import com.model.entities.Entity;
import com.model.entities.Player;
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
        this.texturePath = "textures/player/idle_1.png";
        this.hitboxWidth = 32; // dans tiled il fait plus que 32 de large mais sinon il tombe pas dans les trous donc faut laisser à 32
        this.hitboxHeight = 64; // Pour la hauteur il fait pile 64 dans tiled  
    }

    // GETTERS et SETTERS (flemme de séparer)

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public int getHitboxWidth() {
        return hitboxWidth;
    }

    public void setHitboxWidth(int hitboxWidth) {
        this.hitboxWidth = hitboxWidth;
    }

    public int getHitboxHeight() {
        return hitboxHeight;
    }

    public void setHitboxHeight(int hitboxHeight) {
        this.hitboxHeight = hitboxHeight;
    }

    // Méthodes
    @Override
    public Entity create(float x, float y) {
        Player player = new Player();
        player.addComponent(new PositionComponent(x, y));
        player.addComponent(new VelocityComponent(this.vx, this.vy));
        player.addComponent(new SpriteComponent(this.texturePath));
        player.addComponent(new InputComponent());
        player.addComponent(new HitboxComponent(x, y, this.hitboxWidth, this.hitboxHeight));

        //System.out.println("TEST> l'usine a fabriquée un player");
        return player;
    }
}    
