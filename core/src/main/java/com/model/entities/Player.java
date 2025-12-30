package com.model.entities;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


// Engine
import com.model.components.concreteComponents.PositionComponent;
import com.model.components.concreteComponents.VelocityComponent;
import com.model.components.concreteComponents.HitboxComponent;
import com.model.components.concreteComponents.SpriteComponent;

// Java
import java.util.LinkedList;
import java.util.List;
// ====================

public class Player extends Entity {
    
    private PositionComponent position;
    private VelocityComponent velocity;
    private HitboxComponent hitbox;
    
    private float moveSpeed = 180f;
    private float jumpForce = 400f;
    private float gravity = 900f;

    public boolean left = false;
    public boolean right = false;
    private boolean isGrounded = false;


    // Animation et textures
    public enum State { FALLING, JUMPING, STANDING, RUNNING }; 
    
    public State currentState;
    public State previousState;
    private float stateTimer; 
    private Animation<TextureRegion> playerRun;
    private Animation<TextureRegion> playerJump;
    private Animation<TextureRegion> playerIdle;
    private boolean runningRight;

    

    // Constructeurs
    public Player() {
        super();
        this.setComponents(new LinkedList<>());

        
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        // Chargement des animations
        Array<TextureRegion> frames = new Array<>();

        // 
        for (int i = 1; i <= 11; i++) {
            frames.add(new TextureRegion(new Texture("textures/player/run_" + i + ".png")));
        }
        playerRun = new Animation<>(0.05f, frames); 
        frames.clear(); 

        for (int i = 1; i <= 16; i++) {
            frames.add(new TextureRegion(new Texture("textures/player/jump_" + i + ".png")));
        }
        playerJump = new Animation<>(0.05f, frames);
        frames.clear();

        for (int i = 1; i <= 16; i++) {
            frames.add(new TextureRegion(new Texture("textures/player/idle_" + i + ".png")));
        }
        playerIdle = new Animation<>(0.1f, frames);
        frames.clear();
        
    }

    // Méthodes
    public void jump() {
        if (isGrounded && velocity != null) {
            velocity.setVY(jumpForce);
            isGrounded = false;
        }
    }

    @Override
    public void update(float deltaTime, List<Rectangle> walls) {
        
        if (position == null) position = getComponent(PositionComponent.class);
        if (velocity == null) velocity = getComponent(VelocityComponent.class);
        if (hitbox == null) hitbox = getComponent(HitboxComponent.class);

        
        // test des composants
        if (position == null) {
            System.err.println("ERREUR: PositionComponent manquant sur le Player !");
            return;
        }
        if (velocity == null) {
            System.err.println("ERREUR: VelocityComponent manquant sur le Player !");
            return;
        }
        if (hitbox == null) {
            System.err.println("ERREUR: HitboxComponent manquant sur le Player !");
            return;
        }

        // physique 

        // Gravité
        float newVY = velocity.getVY() - gravity * deltaTime;
        velocity.setVY(newVY);

        
        float newY = position.getY() + velocity.getVY() * deltaTime;

        // System.out.println("Player Y: " + newY + " | Velocity Y: " + velocity.getVY());
        
        position.setY(newY);
        updateHitboxPosition(); 

        // Collision sol/plafond
        isGrounded = false;
        Rectangle bounds = hitbox.getBounds(); 

        for (Rectangle wall : walls) {
            if (bounds.overlaps(wall)) {
                if (velocity.getVY() < 0) { // Chute
                    position.setY(wall.y + wall.height);
                    velocity.setVY(0);
                    isGrounded = true;
                } else if (velocity.getVY() > 0) { // Plafond
                    position.setY(wall.y - bounds.height);
                    velocity.setVY(0);
                }
                updateHitboxPosition();
            }
        }

        // Déplacement horizontal
        velocity.setVX(0);

        if (left) {
            velocity.setVX(-moveSpeed);
            position.setX(position.getX() + velocity.getVX() * deltaTime);
        }
        if (right) {
            velocity.setVX(moveSpeed); 
            position.setX(position.getX() + velocity.getVX() * deltaTime);
        }
        updateHitboxPosition();

        // Collision murs
        for (Rectangle wall : walls) {
            if (bounds.overlaps(wall)) {
                if (left) position.setX(wall.x + wall.width);
                if (right) position.setX(wall.x - bounds.width);
                updateHitboxPosition();
            }
        }

        // Respawn on tombe (test)
        if (position.getY() < -300) {
            // System.out.println(">>> RESPAWN <<<");
            position.setY(300);
            velocity.setVY(0);
            updateHitboxPosition();
        }

        SpriteComponent spriteComp = getComponent(SpriteComponent.class);
        
        if (spriteComp != null) {
            TextureRegion regionToDraw = getFrame(deltaTime);
            
            spriteComp.setCurrentRegion(regionToDraw); 
        } else {
            System.err.println("ERREUR: SpriteComponent manquant sur le Player !");
    }
}

    private void updateHitboxPosition() {
        hitbox.getBounds().setPosition(position.getX(), position.getY());
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public float getJumpForce() {
        return jumpForce;
    }

    public void setJumpForce(float jumpForce) {
        this.jumpForce = jumpForce;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public TextureRegion getFrame(float dt) {
        currentState = getState();

        TextureRegion region;

        switch (currentState) {
            case JUMPING:
                region = playerJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = playerRun.getKeyFrame(stateTimer, true); 
                break;
            case FALLING:
            case STANDING:
            default:
                region = playerIdle.getKeyFrame(stateTimer, true);
                break;
        }

        // Si il va à gauche mais l'image regarde à droite alors on  tourne l'image
        if ((velocity.getVX() < 0 || !runningRight) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        }
        // Si il va à droite mais l'image regarde à gauche alors on tourne l'image
        else if ((velocity.getVX() > 0 || runningRight) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }
        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        previousState = currentState;

        return region;
    }

    public State getState() {
        if (velocity.getVY() > 0)
            return State.JUMPING;
        
        else if (velocity.getVY() < 0)
            return State.FALLING;
        
        else if (velocity.getVX() != 0)
            return State.RUNNING;
        
        else
            return State.STANDING;
    }
}