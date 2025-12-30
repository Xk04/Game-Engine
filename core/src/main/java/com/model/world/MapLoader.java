package com.model.world;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Polygon;

// Engine
// Java
import java.util.ArrayList;
import java.util.List;
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

    public List<Rectangle> getCollisionRectangles() {
        List<Rectangle> collisions = new ArrayList<>();
        
        TiledMapTileLayer layer = (TiledMapTileLayer) currentMap.getLayers().get("Sol");

        if (layer == null) {
            System.out.println("ERREUR : Le calque 'Sol' est introuvable !");
            return collisions;
        }

        float tileSize = layer.getTileWidth();

        for (int x = 0; x < layer.getWidth(); x++) {
            for (int y = 0; y < layer.getHeight(); y++) {
                TiledMapTileLayer.Cell cell = layer.getCell(x, y);
                
                if (cell != null) {
                    com.badlogic.gdx.maps.tiled.TiledMapTile tile = cell.getTile();
                    
                    if (tile.getObjects().getCount() > 0) {
                        for (com.badlogic.gdx.maps.MapObject object : tile.getObjects()) {
                            
                            // cas 1 ça hitbox c'est 32x32 "rectangle" en vrai carre
                            if (object instanceof RectangleMapObject) {
                                Rectangle localRect = ((RectangleMapObject) object).getRectangle();
                                collisions.add(new Rectangle(
                                    (x * tileSize) + localRect.x,
                                    (y * tileSize) + localRect.y,
                                    localRect.width,
                                    localRect.height
                                ));
                            }
                            // cas 2 ça hitbox c'est un polygone (c'est different du rectangle)
                            else if (object instanceof PolygonMapObject) {
                                // On récupère la forme
                                Polygon poly = ((PolygonMapObject) object).getPolygon();
                                Rectangle bounds = poly.getBoundingRectangle();

                                collisions.add(new Rectangle(
                                    (x * tileSize) + bounds.x,
                                    (y * tileSize) + bounds.y,
                                    bounds.width,
                                    bounds.height
                                ));
                            }
                        }
                    } else {
                        collisions.add(new Rectangle(x * tileSize, y * tileSize, tileSize, tileSize));
                    }
                }
            }
        }
        return collisions;
    }
}