package com.model.factories.caracterFactories;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.model.entities.Entity;
import com.model.components.concreteComponents.*;

public class PlayerFactoryTest {

    @Test
    public void testCreatePlayer() {
        PlayerFactory factory = new PlayerFactory();
        float x = 100f;
        float y = 200f;
        
        Entity player = factory.create(x, y);

        assertThat(player, is(notNullValue()));
        
        // COMPONENTS ESSENTIELS
        assertThat(player.getComponent(PositionComponent.class), is(notNullValue()));
        assertThat(player.getComponent(VelocityComponent.class), is(notNullValue()));
        assertThat(player.getComponent(AnimationComponent.class), is(notNullValue()));
        assertThat(player.getComponent(InputComponent.class), is(notNullValue()));
        assertThat(player.getComponent(HitboxComponent.class), is(notNullValue()));

        PositionComponent pos = player.getComponent(PositionComponent.class);
        assertThat(pos.getX(), is(x));
        assertThat(pos.getY(), is(y));
    }
}