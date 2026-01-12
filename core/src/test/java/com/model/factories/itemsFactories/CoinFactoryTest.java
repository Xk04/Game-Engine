package com.model.factories.itemsFactories;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import com.model.entities.Entity;

public class CoinFactoryTest {

    @Test
    public void testCreate() {
        CoinFactory factory = new CoinFactory();
        Entity coin = factory.create(10.0f, 10.0f);

        assertThat(coin, is(nullValue()));
    }
}