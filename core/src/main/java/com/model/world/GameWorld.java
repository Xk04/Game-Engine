package com.model.world;
import com.badlogic.gdx.maps.MapProperties;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
// Engine
import com.model.entities.Entity;
import java.util.ArrayList;
// Java
import java.util.List;
// ====================



/**
 * Représente l'état du monde de jeu : la carte Tiled et la liste d'entités.
 * <p>
 * Cette classe est composé de méthodes utiles aux mise à jours des entités + map.
 */
public class GameWorld { 
    private TiledMap tiledMap;
    private List<Entity> entities;
    private Entity player;

    // Constructeurs
    public GameWorld(TiledMap tiledMap) {
        this.setTiledMap(tiledMap);
        this.setEntities();
        //this.setPlayer();
        System.out.println(this.toString());
    }

    // GETTERS
    public TiledMap getTiledMap() {
        return this.tiledMap;
    }

    public List<Entity> getEntities() {
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

    // SETTERS
    private void setTiledMap(TiledMap tiledMap) {
        if (tiledMap == null) {
            throw new IllegalAccessError("\n> Erreur lors de l'initialisation de la map Tiled\n" + "| Veuillez saisir une map non \"null\"");
        } else {
            this.tiledMap = tiledMap;
        }
    }

    private void setEntities() {
        if (entities == null) {
            this.entities = new ArrayList<>();
        } else {
            throw new IllegalAccessError("\n> Impossible d'allouer la liste d'entités:\n" + "| Liste déjà remplie");
        }
    }

    private void setPlayer(Entity p) {
        if (p != null) {
            throw new IllegalAccessError("\n> Initialisation du joueur impossible:\n" + "| Allocation d'un null => pas de sens");
        }
        if (this.player != null) {
            throw new IllegalAccessError("\n> Initialisation du joueur déjà effectuée");
        } else {
            this.player = p;
        }
    }

    // Méthodes
    @Override
    public String toString() {
        String map = "\n  | Tiled map: " + this.getTiledMap();
        String width = "\n  | Width: "+ this.getMapWidth() + " px";
        String height = "\n  | Height: " + this.getMapHeight() + " px";
        String player = ",\n  | Player: " + this.getPlayer();
        String entityList = ",\n  | Entités: " + this.getEntities();
        return "> Game World:" + map + width + height + player + entityList ;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    /** Met à jour toutes les entités de la liste d'entités disposées dans le monde */
    public void update(float deltaTime) {
        int i; 
        for (i = entities.size()-1 ; i >= 0 ; i--) {
            Entity entity = entities.get(i);
            entity.update(deltaTime);
        }
    }
}
