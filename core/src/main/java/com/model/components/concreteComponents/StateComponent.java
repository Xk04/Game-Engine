package com.model.components.concreteComponents;


// === Importations ===
// LibGDX
// Engine
import com.model.components.Component;
// Java
// ====================



public class StateComponent extends Component {

    // differents etats
    public static final int IDLE = 0;
    public static final int RUN = 1;
    public static final int JUMP = 2;
    public static final int WALK = 3;
    public static final int SLIDE = 4;
    public static final int DEAD = 5;

    public int etatCourant;
    public int etatPrecedent;
    public boolean direction; // true = droite, false = gauche
    public float stateTime; // temps ecoule dans l'etat courant


    // Constructeur
    public StateComponent() {
        this.etatCourant = IDLE;
        this.etatPrecedent = IDLE;
        this.stateTime = 0f;
        this.direction = true;
    }
    

    // GETTER
    public int getEtatCourant() {
        return this.etatCourant;
    }

    public int getEtatPrecedent() {
        return etatPrecedent;
    }

    public boolean isDirection() {
        return direction;
    }

    public float getStateTime() {
        return stateTime;
    }


    // SETTER
    public void setEtatCourant(int etatCourant) {
        this.etatCourant = etatCourant;
    }

    public void setEtatPrecedent(int etatPrecedent) {
        this.etatPrecedent = etatPrecedent;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setStateTime(float stateTime) {
        this.stateTime = stateTime;
    }


    // Méthodes
}