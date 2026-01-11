package com.model.factories.caracterFactories;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.model.entities.Entity;

public class EnnemyFactoryTest {

    @Test
    public void testCreate() {
        EnnemyFactory factory = new EnnemyFactory();
        Entity ennemy = factory.create(10.0f, 20.0f);

        // la fontion create return null 
        assertThat(ennemy, is(nullValue()));
    }
}