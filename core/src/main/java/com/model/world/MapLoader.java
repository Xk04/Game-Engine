package com.model.world;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
// Engine
// Java
// ====================



/**
 * Charge des cartes Tiled (.tmx) à partir d'un chemin.
 * <p>
 * Encapsule {@link com.badlogic.gdx.maps.tiled.TmxMapLoader} et génère
 * la map demandée avec currentMapPath.
 */
public class MapLoader {
    private TmxMapLoader mapLoader;
    private TiledMap currentMap;
    private String currentMapPath;

    // Constructeurs
    public MapLoader() {
        this.mapLoader = new TmxMapLoader();
    }

    // GETTERS
    public TmxMapLoader getmapLoader() {
        return this.mapLoader;
    }

    public TiledMap getCurrentMap() {
        return this.currentMap;
    }

    public String getCurrentMapPath() {
        return this.currentMapPath;
    }

    // SETTERS
    private void setCurrentMap(String newMapPath) {
        try {
            this.currentMap = mapLoader.load(newMapPath);
        } catch (Exception err) {
            throw new IllegalAccessError("\n> Impossible de charger la map:\n" + "  | Détails de l'erreur: " + err);
        }
    }

    private void setCurrentMapPath(String newMapPath) {
        if (newMapPath == "") {
            throw new IllegalAccessError("\n> Le chemin d'accès à la map ne peut pas être vide:\n" + "  | mapPath = \"\"");
        } else {
            this.currentMapPath = newMapPath;
        }
    }

    // Méthodes
    public TiledMap loadMap(String newMapPath) {
        System.out.print("> Chargement de la carte : ");
        this.setCurrentMapPath(newMapPath);
        this.setCurrentMap(this.getCurrentMapPath());
        System.out.println(this.getCurrentMapPath());
        return this.currentMap;
    }
}


