package com.model.components.concreteComponents;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class VelocityComponentTest {

    @Test
    public void testInitialisation() {
        float vx = 10.0f;
        float vy = -5.0f;
        VelocityComponent vel = new VelocityComponent(vx, vy);

        assertThat(vel.getVX(), is(vx));
        assertThat(vel.getVY(), is(vy));
        assertThat(vel.getVelocity(), is(notNullValue()));
        assertThat(vel.getVelocity()[0], is(vx));
        assertThat(vel.getVelocity()[1], is(vy));
    }

    @Test
    public void testSetVX() {
        VelocityComponent vel = new VelocityComponent(0f, 0f);
        vel.setVX(15.5f);
        assertThat(vel.getVX(), is(15.5f));
    }

    @Test
    public void testSetVY() {
        VelocityComponent vel = new VelocityComponent(0f, 0f);
        vel.setVY(-20.0f);
        assertThat(vel.getVY(), is(-20.0f));
    }

    @Test
    public void testSetVelocity() {
        VelocityComponent vel = new VelocityComponent(0f, 0f);
        vel.setVelocity(100f, 200f);
        
        float[] velocity = vel.getVelocity();
        assertThat(velocity[0], is(100f));
        assertThat(velocity[1], is(200f));
    }
}