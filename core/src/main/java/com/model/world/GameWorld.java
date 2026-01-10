package com.model.world;
import com.badlogic.gdx.maps.MapProperties;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
// Engine
import com.model.entities.Entity;
import com.model.systems.*;
// Java
import java.util.Map;
import java.util.HashMap;
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


    private Vector2 spawnLocation;

    // Constructeurs
    public GameWorld(MapLoader map, String mapPath, HashMap<String, Entity> newEntities) {
        this.setEntities(newEntities);
        this.mapLoader = map;
        this.mapLoader.loadMap(mapPath);
        this.tiledMap = this.mapLoader.getCurrentMap();
        this.spawnLocation = mapLoader.getPlayerStart();
        System.out.println("> Spawn sauvegardé en : " + spawnLocation);
        System.out.println(this.toString());
    }

    // GETTERS
    public MapLoader getMapLoader() {
        return mapLoader;
    }

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
    public void setTiledMap(TiledMap tiledMap) {
        if (tiledMap == null) {
            throw new IllegalAccessError("\n> Erreur lors de l'initialisation de la map Tiled\n" + "| Veuillez saisir une map non \"null\"");
        } else {
            this.tiledMap = tiledMap;
        }
    }

    public void setEntities(HashMap<String, Entity> entityMap) {
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

    public void update(float dt) {

        for (Map.Entry<String, Entity> entity : this.entities.entrySet()) {
            PhysicsSystem.update(this.mapLoader, entity, dt);
            AnimationSystem.update(entity, dt);
            CollisionSystem.update(this.mapLoader, entity, dt);
        }
        
    }
}
