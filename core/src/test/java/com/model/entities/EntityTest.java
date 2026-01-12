package com.model.entities;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.model.components.concreteComponents.VelocityComponent;
import java.util.LinkedList;
import com.model.components.Component;

public class EntityTest {

    @Test
    public void testInitialisation() {
        Entity entity = new Entity();
        // LISTE VIDE
        assertThat(entity.getComponent(VelocityComponent.class), is(nullValue()));
    }

    @Test
    public void testAddComponentEtGet() {
        Entity entity = new Entity();
        VelocityComponent vel = new VelocityComponent(1f, 1f);
        
        entity.addComponent(vel);
        
        VelocityComponent retrieved = entity.getComponent(VelocityComponent.class);
        assertThat(retrieved, is(notNullValue()));
        assertThat(retrieved, is(vel));
    }

    @Test
    public void testSetComponents() {
        Entity entity = new Entity();
        LinkedList<Component> list = new LinkedList<>();
        VelocityComponent vel = new VelocityComponent(5f, 5f);
        list.add(vel);

        entity.setComponents(list);

        assertThat(entity.getComponent(VelocityComponent.class), is(notNullValue()));
    }

    @Test
    public void testGetComponentInexistant() {
        Entity entity = new Entity();
        assertThat(entity.getComponent(VelocityComponent.class), is(nullValue()));
    }
}   