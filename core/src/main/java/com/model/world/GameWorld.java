package com.model.world;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
// Engine
import com.model.entities.Entity;
import com.model.components.concreteComponents.PlayerPhysicsComponent;
// Java
import java.util.Map;
import java.util.HashMap;
import java.util.List;
// ====================



/**
 * Représente l'état du monde de jeu : la carte Tiled et la liste d'entités.
 * <p>
 * Cette classe est composé de méthodes utiles aux mise à jours des entités + map.
 */
public class GameWorld { 
    private TiledMap tiledMap;
    private HashMap<String, Entity> entities;
    private MapLoader mapLoader;

    // Constructeurs
    public GameWorld(TiledMap tiledMap, HashMap<String, Entity> newEntities) {
        this.setTiledMap(tiledMap);
        this.setEntities(newEntities);
        this.mapLoader = new MapLoader(tiledMap);
        System.out.println(this.toString());
    }

    // GETTERS
    public TiledMap getTiledMap() {
        return this.tiledMap;
    }

    public HashMap<String, Entity> getEntities() {
        return this.entities;
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


    // Méthodes
    @Override
    public String toString() {
        String map = "\n  | Tiled map: " + this.getTiledMap() + ",";
        String width = "\n  | Width: "+ this.getMapWidth() + " px,";
        String height = "\n  | Height: " + this.getMapHeight() + " px,";
        String player = "\n  | Player: "   + ",";
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
        
        List<Rectangle> walls = mapLoader.getCollisionRectangles();
        
        for (Entity entity : entities.values()) {
            
            PlayerPhysicsComponent physics = entity.getComponent(PlayerPhysicsComponent.class);
            
            if (physics != null) {
                physics.update(entity, deltaTime, walls);
            }
        }
    }

}
