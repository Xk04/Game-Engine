package com.model.world;


// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.MapProperties;
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
    public GameWorld(MapLoader newMapLoader, String mapPath, HashMap<String, Entity> newEntities) {
        this.entities = new HashMap<String, Entity>();
        this.setEntities(newEntities);
        this.setMapLoader(newMapLoader);
        this.setTiledMap(this.mapLoader.getCurrentMap());
        this.setSpawnLocation(this.mapLoader.getPlayerStart());
        System.out.println(this.toString());
    }


    // GETTERS
    public TiledMap getTiledMap() {
        return this.tiledMap;
    }

    public HashMap<String, Entity> getEntities() {
        return this.entities;
    }

    public MapLoader getMapLoader() {
        return this.mapLoader;
    }

    public Vector2 getSpawnLocation() {
        return this.spawnLocation;
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
        if (entityMap == null) {
            this.entities = new HashMap<String, Entity>();
        } 
        if (entityMap != null) {
            for (Map.Entry<String, Entity> elt : entityMap.entrySet()) {
                this.entities.put(elt.getKey(), elt.getValue());
            }
        }
    }

    public void setMapLoader(MapLoader mapLoader) {
        this.mapLoader = mapLoader;
    }

    public void setSpawnLocation(Vector2 spawnLocation) {
        this.spawnLocation = spawnLocation;
    }


    // Méthodes
    @Override
    public String toString() {
        String map =    "\n  | Tiled map: " + this.getTiledMap() + ",";
        String width =  "\n  | Width: "+ this.getMapWidth() + " px,";
        String height = "\n  | Height: " + this.getMapHeight() + " px,";
        String entityList = "\n  | Entities: " + this.getEntities();
        String spawn =  "\n  | Spawn found at : " + this.spawnLocation;
        return "⭢ Game World:" + map + width + height + entityList + spawn;
    }

    public void addEntity(String type, Entity entity) {
        this.entities.put(type, entity);
    }

    public void removeEntity(String entityTag) {
        this.entities.remove(entityTag);
    }

    public boolean update(float dt) {
        for (Map.Entry<String, Entity> entity : this.entities.entrySet()) {
            PhysicsSystem.update(this.mapLoader, entity, dt);
            AnimationSystem.update(this.mapLoader, entity, dt);
            if (CollisionSystem.update(this.mapLoader, entity, dt)) {
                return true; // Niveau terminé
            }
        }
        return false;
    }
}
