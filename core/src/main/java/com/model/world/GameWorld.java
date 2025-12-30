package com.model.world;
import com.badlogic.gdx.maps.MapProperties;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
// Engine
import com.model.entities.Entity;
// Java
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
// ====================



/**
 * Représente l'état du monde de jeu : la carte Tiled et la liste d'entités.
 * <p>
 * Cette classe est composé de méthodes utiles aux mise à jours des entités + map.
 */
public class GameWorld { 
    private TiledMap tiledMap;
    private HashMap<String, Entity> entities;

    private Entity player;
    private List<Rectangle> collisionRect = new ArrayList<>();

    // Constructeurs
    public GameWorld(TiledMap tiledMap, HashMap<String, Entity> newEntities) {
        this.setTiledMap(tiledMap);
        this.setEntities(newEntities);

        if (this.entities.containsKey("player1")) {
            this.player = this.entities.get("player1");
        }

        System.out.println(this.toString());
    }

    // GETTERS
    public TiledMap getTiledMap() {
        return this.tiledMap;
    }

    public HashMap<String, Entity> getEntities() {
        return this.entities;
    }

    public Entity getPlayer() {
        return this.player;
    }

    public int getMapWidth() {
        MapProperties properties = this.tiledMap.getProperties();
        int width = properties.get("width", Integer.class);
        int tileWidth = properties.get("tilewidth", Integer.class);
        return width*tileWidth;
    }

    public int getMapHeight() {
        MapProperties properties = this.tiledMap.getProperties();
        int height = properties.get("height", Integer.class);
        int tileHeight = properties.get("tileheight", Integer.class);
        return height*tileHeight;
    }

    public List<Rectangle> getCollisionRect() {
        return this.collisionRect;
    }

    // SETTERS
    private void setTiledMap(TiledMap tiledMap) {
        if (tiledMap == null) {
            throw new IllegalAccessError("\n> Erreur lors de l'initialisation de la map Tiled\n" + "| Veuillez saisir une map non \"null\"");
        } else {
            this.tiledMap = tiledMap;
        }
    }

    private void setEntities(HashMap<String, Entity> entityMap) {
        if (entities == null) {
            this.entities = new HashMap<String, Entity>();
        } 
        if (entityMap != null) {
            for (Map.Entry<String, Entity> elt : entityMap.entrySet()) {
                this.entities.put(elt.getKey(), elt.getValue());
            }
        }
    }

    public void setPlayer(Entity p) {
        this.player = p;
    }
    
    public void setCollisionRect(List<Rectangle> rect) {
        this.collisionRect = rect;
    }


    // Méthodes
    @Override
    public String toString() {
        String map = "\n  | Tiled map: " + this.getTiledMap() + ",";
        String width = "\n  | Width: "+ this.getMapWidth() + " px,";
        String height = "\n  | Height: " + this.getMapHeight() + " px,";
        String player = "\n  | Player: " + this.player + ",";
        String entityList = "\n  | Entités: " + this.getEntities();
        return "> Game World:" + map + width + height + player + entityList ;
    }

    public void addEntity(String type, Entity entity) {
        this.entities.put(type, entity);
    }

    public void removeEntity(String entityTag) {
        this.entities.remove(entityTag);
    }

    public void update(float deltaTime) {
        // Màj de toutes les entités
        for (Entity entity : entities.values()) {
            entity.update(deltaTime, this.collisionRect);
        }

        // Màj du joueur
        if (this.player != null) {
            this.player.update(deltaTime, this.collisionRect);
        }
    }
}
