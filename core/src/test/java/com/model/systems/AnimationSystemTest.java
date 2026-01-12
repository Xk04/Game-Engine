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
        Entity entity = new Entity();

        StateComponent state = new StateComponent();
        state.setEtatCourant(StateComponent.RUN);
        state.setStateTime(0f);
        entity.addComponent(state);

        SpriteComponent sprite = new SpriteComponent("textures/player/santa_idle_1.png");
        entity.addComponent(sprite);

        AnimationComponent animComp = new AnimationComponent();
        animComp.addAnimation(StateComponent.RUN, "textures/player/santa_run", 11, 0.1f);
        entity.addComponent(animComp);

        HashMap<String, Entity> map = new HashMap<>();
        map.put("player", entity);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        AnimationSystem.update(null, entry, 0.15f);

        assertThat(state.stateTime, is(0.15f));
        assertThat(sprite.getTexturePath(), is("textures/player/santa_run_2.png"));
    }

    @Test
    public void testBoucleAnimationSanta() {
        Entity entity = new Entity();

        StateComponent state = new StateComponent();
        state.setEtatCourant(StateComponent.WALK);
        state.setStateTime(0f);
        entity.addComponent(state);

        SpriteComponent sprite = new SpriteComponent("textures/player/santa_idle_1.png");
        entity.addComponent(sprite);

        AnimationComponent animComp = new AnimationComponent();
        animComp.addAnimation(StateComponent.WALK, "textures/player/santa_walk", 13, 0.1f);
        entity.addComponent(animComp);

        HashMap<String, Entity> map = new HashMap<>();
        map.put("player", entity);
        Map.Entry<String, Entity> entry = map.entrySet().iterator().next();

        AnimationSystem.update(null, entry, 1.4f);

        assertThat(sprite.getTexturePath(), is("textures/player/santa_walk_2.png"));
    }
}