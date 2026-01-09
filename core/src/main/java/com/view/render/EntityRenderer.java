package com.view.render;

// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// Engine
import com.model.world.GameWorld;
import com.view.assets.TextureManager;
import com.view.camera.CameraManager;
import com.model.entities.Entity;
import com.model.components.concreteComponents.*;
// Java
import java.util.Map;
// ====================



public class EntityRenderer {

    private SpriteBatch batch;

    // Constructeurs
    public EntityRenderer() {
        this.batch = new SpriteBatch();
    }

    // GETTERS
    public SpriteBatch getBatch() {
        return batch;
    }    
    // SETTERS
    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    // Méthodes
    public void render(GameWorld world, CameraManager camera) {
        batch.setProjectionMatrix(camera.getCamera().combined);
        batch.begin();

        for (Map.Entry<String, Entity> entry : world.getEntities().entrySet()) {
            Entity entity = entry.getValue();

            PositionComponent pos = entity.getComponent(PositionComponent.class);
            SpriteComponent sprite = entity.getComponent(SpriteComponent.class);

            this.drawSprite(sprite, pos);
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }


    public void drawSprite(SpriteComponent sprite, PositionComponent pos) {
        if (pos != null && sprite != null) {
            Texture texture = TextureManager.get(sprite.getTexturePath());
            batch.draw(texture, pos.getX(), pos.getY());
        }
    }

    
}
