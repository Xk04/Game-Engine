package com.view.assets;

import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;
import java.util.Map;

public class TextureManager {
    
    private static final Map<String, Texture> textures = new HashMap<>();

    public static Texture get(String path) {
        if (!textures.containsKey(path)) {
            textures.put(path, new Texture(path));
        }
        return textures.get(path);
    }

    public static void disposeAll() {
        for (Texture texture : textures.values()) {
            texture.dispose();
        }
        textures.clear();
    }
}