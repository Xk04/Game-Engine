package com.model.systems;

// === Importations ===
// LibGDX

// Engine
import com.model.entities.Entity;
import com.model.components.concreteComponents.AnimationComponent;
import com.model.components.concreteComponents.SpriteComponent;
import com.model.components.concreteComponents.StateComponent;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.HashMap;
import java.util.Map;
// ====================

public class AnimationSystemTest {

    @Test
    public void testChangementDeFrameSanta() {
        // GIVEN
        Entity entity = new Entity();

        StateComponent state = new StateComponent();
        state.setEtatCourant(StateComponent.RUN);
        state.setStateTime(0f);
        entity.addComponent(state);

        SpriteComponent sprite = new SpriteComponent("textures/player/santa_idle_1.png");
        entity.addComponent(sprite);

        AnimationComponent animComp = new AnimationComponent();
        // Cas normal : Santa court
        animComp.addAnimation(StateComponent.RUN, "textures/player/santa_run", 11, 0.1f);
        entity.addComponent(animComp);

        HashMap<String, Entity> map = new HashMap<>();
        map.put("player", entity);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        // WHEN
        AnimationSystem.update(entry, 0.15f);

        // THEN
        assertThat(state.getStateTime(), is(0.15f));
        // 0.15s / 0.1s = 1.5 -> Index 1 -> Image 2
        assertThat(sprite.getTexturePath(), is("textures/player/santa_run_2.png"));
    }

    @Test
    public void testBoucleAnimationSanta() {
        // GIVEN
        Entity entity = new Entity();

        StateComponent state = new StateComponent();
        state.setEtatCourant(StateComponent.WALK);
        entity.addComponent(state);

        SpriteComponent sprite = new SpriteComponent("textures/player/santa_idle_1.png");
        entity.addComponent(sprite);

        AnimationComponent animComp = new AnimationComponent();

        // CORRECTION ICI : Bien utiliser "santa_walk" et pas "santa_run"
        animComp.addAnimation(StateComponent.WALK, "textures/player/santa_walk", 13, 0.1f);

        entity.addComponent(animComp);

        HashMap<String, Entity> map = new HashMap<>();
        map.put("player", entity);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        // WHEN
        // On avance le temps de 1.4s (Animation totale = 1.3s)
        AnimationSystem.update(entry, 1.4f);

        // THEN
        // 1.4 / 0.1 = 14 -> 14 % 13 = 1 -> 1 + 1 = 2
        assertThat(sprite.getTexturePath(), is("textures/player/santa_walk_2.png"));
    }
}