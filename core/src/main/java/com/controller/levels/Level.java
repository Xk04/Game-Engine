package com.controller.levels;


// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Vector2;
// Engine
import com.model.world.GameWorld;
import com.model.world.MapLoader;
import com.model.entities.Entity;
import com.model.factories.EntityFactory;
import com.model.factories.caracterFactories.PlayerFactory;
// Java
import java.util.HashMap;
// ====================



/**
 * Implémentation partielle commune aux niveaux (gestion du niveau suivant).
 */
public abstract class Level {

    private MapLoader mapLoader;
    private EntityFactory playerFactory;
    private GameWorld world;
    private HashMap<String, Entity> entities;
    private String mapPath;


    // Constructeurs
    public Level(String mapPath) {
        System.out.println("    ► Level: " + this.getClass().getName());
        this.setMapPath(mapPath);
        this.setEntities(new HashMap<>());
        this.setMap(new MapLoader(this.getMapPath())); 
        this.setPlayerFactory(new PlayerFactory());
        System.out.println("        | Map Loader: " + this.getMapLoader().toString());
        System.out.println("        | Map Path: " + this.getMapPath());
    }


    // GETTERS
    public MapLoader getMapLoader() {
        return this.mapLoader;
    }

    public EntityFactory getPlayerFactory() {
        return this.playerFactory;
    }

    public GameWorld getWorld() {
        return this.world;
    }

    public HashMap<String, Entity> getEntities() {
        return this.entities;
    }

    public String getMapPath() {
        return this.mapPath;
    }


    // SETTERS
    public void setMap(MapLoader newMapLoader) {
        this.mapLoader = newMapLoader;
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

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }


    // Méthodes
    public GameWorld setUpGameWorld() {
        Vector2 spawnPoint = this.mapLoader.getPlayerStart();
        Entity player = this.playerFactory.create(spawnPoint.x, spawnPoint.y);
        this.entities.put("player1", player);

        this.setWorld(new GameWorld(this.getMapLoader(), this.getMapPath(), this.getEntities()));

        return this.world;
    }
}
