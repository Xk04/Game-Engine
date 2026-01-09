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
    public StartingPoint(String newMapPath) {
        super(newMapPath);
    }

    // GETTERS

    // SETTERS

    // Méthodes
    @Override
    public GameWorld setUpGameWorld() {
        this.entities = new HashMap<>();
        this.map = new MapLoader(); 
        this.playerFactory = new PlayerFactory();

        map.loadMap(this.getMapPath());
        Vector2 spawnPoint = map.getPlayerStart();

        //this.entities.put("player1", this.playerFactory.create(300, 300));
        this.entities.put("player1", this.playerFactory.create(spawnPoint.x, spawnPoint.y));
        
        this.world = new GameWorld(map.getCurrentMap(), this.entities);
        return world;
    }
}
