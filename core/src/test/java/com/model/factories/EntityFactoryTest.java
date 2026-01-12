package com.model.factories;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.model.entities.Entity;

public class EntityFactoryTest {

    @Test
    public void testAbstractStructure() {
        EntityFactory factory = new EntityFactory() {
            @Override
            public Entity create(float x, float y) {
                return new Entity();
            }
        };

        Entity e = factory.create(0f, 0f);
        assertThat(e, is(notNullValue()));
    }
}