package com.model.components.concreteComponents;

// === Importations ===
// LibGDX

// Engine
// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class StateComponentTest {

    @Test
    public void testValeursInitiales() {
        StateComponent state = new StateComponent();
        
        assertThat(state.getEtatCourant(), is(StateComponent.IDLE));
        assertThat(state.getEtatPrecedent(), is(StateComponent.IDLE));
        
        assertThat(state.getStateTime(), is(0f));
        
        assertThat(state.isDirection(), is(true));
    }

    @Test
    public void testChangementEtat() {
        StateComponent state = new StateComponent();

        state.setEtatPrecedent(state.getEtatCourant()); // Sauvegarde l'ancien
        state.setEtatCourant(StateComponent.RUN);
        state.setStateTime(0.5f); // 0.5 secondes écoulées

        assertThat(state.getEtatPrecedent(), is(StateComponent.IDLE));
        assertThat(state.getEtatCourant(), is(StateComponent.RUN));
        assertThat(state.getStateTime(), is(0.5f));
    }

    @Test
    public void testChangementDirection() {
        StateComponent state = new StateComponent();

        state.setDirection(false); // Regarde à gauche

        assertThat(state.isDirection(), is(false));
    }
}