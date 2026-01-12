package com.model.components.concreteComponents;

// === Importations ===
// Engine

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
// ====================

public class AnimationComponentTest {

    @Test
    public void testInitialisation() {
        AnimationComponent animComp = new AnimationComponent();

        assertThat(animComp.getAnimations(), is(notNullValue()));
        assertThat(animComp.getAnimations().size(), is(0));
    }

    @Test
    public void testAjoutAnimation() {
        AnimationComponent animComp = new AnimationComponent();
        int stateIdle = 0;
        String path = "player/idle.png";
        int frames = 4;
        float speed = 0.1f;

        animComp.addAnimation(stateIdle, path, frames, speed);

        assertThat(animComp.getAnimations().size(), is(1));
        
        assertThat(animComp.getAnimations().containsKey(stateIdle), is(true));

        AnimInfo info = animComp.getAnimations().get(stateIdle);
        assertThat(info, is(notNullValue()));
        
        assertThat(info.getPath(), is(path));
        assertThat(info.getCount(), is(frames));
        assertThat(info.getSpeed(), is(speed));
    }
}