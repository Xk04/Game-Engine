package com.controller.inputs;

// === Importations ===
// LibGDX
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
// Engine
import com.model.entities.Entity;
import com.model.components.concreteComponents.InputComponent;
// Java
// ====================


/**
 * Gestionnaire des entrées utilisateur pour les événements clavier.
 * <p>
 * Cette classe étend {@link InputAdapter} de LibGDX et gère les entrées clavier
 * du joueur. Elle supporte les formats de clavier AZERTY et QWERTY.
 * </p>
 * <p>
 * Les touches gérées sont :
 * <ul>
 *   <li>Gauche : LEFT, Q (AZERTY), A (QWERTY)</li>
 *   <li>Droite : RIGHT, D</li>
 *   <li>Sauter/Haut : SPACE, UP, Z (AZERTY), W (QWERTY)</li>
 * </ul>
 * </p>
 * 
 * @see InputAdapter
 * @see InputComponent
 * @author Reese
 * @version 1.0
 */
public class InputManager extends InputAdapter {

    private InputComponent inputComponent;

    /**
     * Constructeur du gestionnaire d'entrées.
     * <p>
     * Initialise le gestionnaire avec le composant d'entrée du joueur.
     * </p>
     * 
     * @param player l'entité du joueur dont on récupère le composant d'entrée
     * @throws NullPointerException si le composant InputComponent n'existe pas sur l'entité
     */
    public InputManager(Entity player) {
        this.inputComponent = player.getComponent(InputComponent.class);
    }

    /**
     * Récupère le composant d'entrée actuel.
     * 
     * @return le composant {@link InputComponent} géré par ce gestionnaire,
     *         ou {@code null} s'il n'a pas été initialisé
     */
    public InputComponent getInputComponent() {
        return inputComponent;
    }

    /**
     * Définit le composant d'entrée à gérer.
     * 
     * @param inputComponent le nouveau composant {@link InputComponent} à gérer
     */
    public void setInputComponent(InputComponent inputComponent) {
        this.inputComponent = inputComponent;
    }

    /**
     * Gère l'événement d'appui sur une touche.
     * <p>
     * Met à jour le composant d'entrée en fonction de la touche appuyée.
     * Cette méthode supporte les claviers AZERTY et QWERTY.
     * </p>
     * 
     * @param keycode le code de la touche appuyée (voir {@link Keys})
     * @return {@code true} si l'événement a été traité, {@code false} sinon
     * @see Keys#LEFT
     * @see Keys#RIGHT
     * @see Keys#SPACE
     */
    @Override
    public boolean keyDown(int keycode) {
        if (inputComponent == null)
            return false;

        switch (keycode) {
            case Keys.LEFT:
            case Keys.Q: // Support AZERTY
            case Keys.A: // Support QWERTY
                inputComponent.setLeft(true);
                break;
            case Keys.RIGHT:
            case Keys.D:
                inputComponent.setRight(true);
                break;
            case Keys.SPACE:
            case Keys.UP:
            case Keys.Z:
            case Keys.W:
                inputComponent.setSpace(true);
                break;
        }
        return true;
    }

    /**
     * Gère l'événement de relâchement d'une touche.
     * <p>
     * Met à jour le composant d'entrée en relâchant la touche correspondante.
     * Cette méthode supporte les claviers AZERTY et QWERTY.
     * </p>
     * 
     * @param keycode le code de la touche relâchée (voir {@link Keys})
     * @return {@code true} si l'événement a été traité, {@code false} sinon
     * @see Keys#LEFT
     * @see Keys#RIGHT
     * @see Keys#SPACE
     */
    @Override
    public boolean keyUp(int keycode) {
        if (inputComponent == null)
            return false;

        switch (keycode) {
            case Keys.LEFT:
            case Keys.Q:
            case Keys.A:
                inputComponent.setLeft(false);
                break;
            case Keys.RIGHT:
            case Keys.D:
                inputComponent.setRight(false);
                break;
            case Keys.SPACE:
            case Keys.UP:
            case Keys.Z:
            case Keys.W:
                inputComponent.setSpace(false);
                break;
        }
        return true;
    }

}