package com.controller.levels.concreteLevels;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Vector2;
// Engine
import com.model.world.GameWorld;
import com.model.world.MapLoader;
import com.model.entities.Entity;
import com.model.factories.EntityFactory;
import com.model.factories.caracterFactories.*;
import com.controller.levels.Level;
// Java
import java.util.HashMap;
// ====================

/**
  * Niveau de départ (exemple) qui instancie le monde à partir d'une map.
  */
public class StartingPoint extends Level {
    private MapLoader map;
    private EntityFactory playerFactory;
    private GameWorld world;
    private HashMap<String, Entity> entities;

    // Constructeurs
    public StartingPoint() {
        super("maps/level0.tmx");
    }
    
    // GETTERS
    public MapLoader getMap() {
        return map;
    }

    public EntityFactory getPlayerFactory() {
        return playerFactory;
    }

    public GameWorld getWorld() {
        return world;
    }

    public HashMap<String, Entity> getEntities() {
        return entities;
    }

    // SETTERS
    public void setMap(MapLoader map) {
        this.map = map;
    }

    public void setPlayerFactory(EntityFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    public void setWorld(GameWorld world) {
        this.world = world;
    }

    public void setEntities(HashMap<String, Entity> entities) {
        this.entities = entities;
    }

    // Méthodes
    @Override
    public GameWorld setUpGameWorld() {
        this.entities = new HashMap<>();
        this.map = new MapLoader(); 
        this.playerFactory = new PlayerFactory();
        
        this.world = new GameWorld(this.map, this.getMapPath(), null);

        Vector2 spawnPoint = this.world.getMapLoader().getPlayerStart();
        this.entities.put("player1", this.playerFactory.create(spawnPoint.x, spawnPoint.y));

        this.world.setEntities(this.entities);

        return world;
    }
}