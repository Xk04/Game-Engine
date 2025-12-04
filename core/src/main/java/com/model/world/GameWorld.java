package com.model.world;

// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;

// Engine
import com.model.entities.Entity;

import java.util.ArrayList;
// Java
import java.util.List;
// ====================


public class GameWorld { 
    private TiledMap tiledMap;
    private String mapPath;
    private List<Entity> entities;
    private Entity player;

    // Constructeurs
    public GameWorld(TiledMap tiledMap, String mapPath) {
        System.out.println("\n> === Initialisation du GameWorld === <\n");

        this.setTiledMap(tiledMap);
        this.setMapPath(mapPath);
        this.setEntities();
        //this.setPlayer();

        System.out.println(this.toString());
        System.out.println("\n> =================================== <\n");
    }

    // GETTERS
    public TiledMap getTiledMap() {
        return this.tiledMap;
    }

    public String getMapPath() {
        return this.mapPath;
    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public Entity getPlayer() {
        return this.player;
    }

    // SETTERS
    private void setTiledMap(TiledMap tiledMap) {
        if (tiledMap == null) {
            throw new IllegalAccessError("> Erreur lors de l'initialisation de la map Tiled\n" + "| Veuillez saisir une map non \"null\"");
        } else {
            this.tiledMap = tiledMap;
        }
    }

    private void setMapPath(String mapPath) {
        if (mapPath == "") {
            throw new IllegalAccessError("> Le chemin d'accès à la map ne peut pas être vide:\n" + "| mapPath = \"\"");
        } else {
            this.mapPath = mapPath;
        }
    }

    private void setEntities() {
        if (entities == null) {
            this.entities = new ArrayList<>();
        } else {
            throw new IllegalAccessError("> Impossible d'allouer la liste d'entités:\n" + "| Liste déjà remplie");
        }
    }

    private void setPlayer(Entity entity) {
        if (entity != null) {
            throw new IllegalAccessError("> Initialisation du joueur impossible:\n" + "| Allocation d'un null => pas de sens");
        }
        if (this.player != null) {
            throw new IllegalAccessError("> Initialisation du joueur déjà effectuée");
        } else {
            this.player = entity;
        }
    }

    // Méthodes
    @Override
    public String toString() {
        return "> Game World:" + "\n| mapPath: " + this.getMapPath() + "\n| Player: " + this.getPlayer() + "\n| Entités: " + this.getEntities();
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    public void update(float deltaTime) {
        int i; 
        for (i = entities.size()-1 ; i >= 0 ; i--) {
            Entity entity = entities.get(i);
            entity.update(deltaTime);
        }
    }
}
