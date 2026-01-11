package com.model.world;

// === Importations ===
// LibGDX
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;

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

    public MapLoader(TiledMap map) {
        this.mapLoader = new TmxMapLoader();
        this.currentMap = map;
    }

    //Constructeur pour les tests 
    public MapLoader(TiledMap map, TmxMapLoader injectedLoader) {
        this.currentMap = map;
        this.mapLoader = injectedLoader;
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

        /**
     * Récupère la position de départ du joueur définie dans Tiled.
     * Cherche un objet nommé "Start" dans le calque "objects".
     * @return Vector2 (x, y)
     */
    public Vector2 getPlayerStart() {
        MapLayer layer = currentMap.getLayers().get("objects");

        if (layer == null) {
            System.err.println("ATTENTION : Le calque 'objects' n'existe pas dans la map. Spawn par défaut (100, 300).");
            return new Vector2(100, 300);
        }

        for (MapObject object : layer.getObjects()) {
            if (object.getName() != null && object.getName().equalsIgnoreCase("Start")) {
                if (object instanceof RectangleMapObject) {
                    Rectangle rect = ((RectangleMapObject) object).getRectangle();
                    System.out.println("> Spawn trouvé en : " + rect.x + ", " + rect.y);
                    return new Vector2(rect.x, rect.y);
                }
            }
        }

        System.err.println("ATTENTION : Aucun objet nommé 'Start' trouvé. Spawn par défaut (100, 300).");
        return new Vector2(100, 300);
    }

    public Rectangle getEndZone() {
        MapLayer layer = currentMap.getLayers().get("objects");
        if (layer == null) return null;

        for (MapObject object : layer.getObjects()) {
            if (object instanceof RectangleMapObject) {
                // On cherche l'objet qui s'appelle "End"
                if ("End".equals(object.getName())) {
                    return ((RectangleMapObject) object).getRectangle();
                }
            }
        }
        return null; // Pas de fin trouvée
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
            System.err.println("ERREUR : Le calque 'Sol' est introuvable dans la map !");
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
                            
                            if (object instanceof RectangleMapObject) {
                                Rectangle localRect = ((RectangleMapObject) object).getRectangle();
                                collisions.add(new Rectangle(
                                    (x * tileSize) + localRect.x,
                                    (y * tileSize) + localRect.y,
                                    localRect.width,
                                    localRect.height
                                ));
                            }
                            else if (object instanceof PolygonMapObject) {
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
        MapLayer objectLayer = currentMap.getLayers().get("objects");
        if (objectLayer != null) {
            for (MapObject object : objectLayer.getObjects()) {
                if (object instanceof RectangleMapObject) {
                    
                    // C'est ici qu'on filtre spécifiquement par le nom "Wall"
                    if ("Wall".equals(object.getName())) {
                        collisions.add(((RectangleMapObject) object).getRectangle());
                    }
                    
                }
            }
        }
        return collisions;
    }
}