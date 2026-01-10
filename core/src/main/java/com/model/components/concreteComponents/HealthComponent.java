package com.model.components.concreteComponents;

// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================

public class HealthComponent extends Component {
    private int currentHealth;
    private int minHealth;
    private int maxHealth;
    
    // Constructeurs
    public HealthComponent(int minHealth, int maxHealth) {
        this.setMinHealth(minHealth);
        this.setMaxHealth(maxHealth);
    }
    
    // GETTERS
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public int getMinHealth() {
        return minHealth;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }

    // SETTERS
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    
    public void setMinHealth(int minHealth) {
        this.minHealth = minHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    
    // Méthodes
}
