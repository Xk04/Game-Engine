package com.view.resources;


// === Importations ===
// LibGDX
import com.badlogic.gdx.graphics.Texture;
// Engine
// Java
import java.util.HashMap;
import java.util.Map;
// ====================



/**
 * Gestionnaire de textures pour charger et mettre en cache les textures du jeu.
 * <p>
 * Cette classe fournit un accès statique aux textures, les chargeant à la demande
 * et les stockant dans un cache pour éviter les rechargements inutiles.
 */
public class TextureManager {

    private static final Map<String, Texture> textures = new HashMap<>();


    // Concstructeurs
    // GETTERS
    public static Texture get(String path) {
        if (!textures.containsKey(path)) {
            textures.put(path, new Texture(path));
        }
        return textures.get(path);
    }
    // SETTERS
    

    // Méthodes


    public static void disposeAll() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();
    }
}