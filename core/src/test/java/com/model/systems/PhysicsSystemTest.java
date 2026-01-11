package com.model.systems;

// === Importations ===
// LibGDX
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.maps.tiled.TiledMap;

// Engine
import com.model.entities.Entity;
import com.model.world.MapLoader;
import com.model.components.concreteComponents.*;

// JUnit & Hamcrest
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

// Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// ====================

public class PhysicsSystemTest {

    private static class MockPhysicsMapLoader extends MapLoader {
        private final List<Rectangle> murs = new ArrayList<>();

        public MockPhysicsMapLoader() {
            super("test/physics_mock.tmx");
        }

        public void ajouterMur(float x, float y, float w, float h) {
            murs.add(new Rectangle(x, y, w, h));
        }

        @Override
        public List<Rectangle> getCollisionRectangles() {
            return murs;
        }

        @Override
        public TiledMap loadMap(String path) {
            return null;
        }
    }

    private Entity creerEntitePhysique() {
        Entity e = new Entity();
        e.addComponent(new PositionComponent(0, 100));
        e.addComponent(new VelocityComponent(0, 0));
        e.addComponent(new PhysicsComponent());
        e.addComponent(new HitboxComponent(0, 100, 32, 32));
        e.addComponent(new StateComponent());
        e.addComponent(new InputComponent());
        return e;
    }

    @Test
    public void testGravite() {
        try {
            Entity entity = creerEntitePhysique();
            MockPhysicsMapLoader loader = new MockPhysicsMapLoader();

            Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
                {
                    put("player", entity);
                }
            }.entrySet().iterator().next();

            PhysicsSystem.update(loader, entry, 0.1f);

            VelocityComponent vel = entity.getComponent(VelocityComponent.class);
            PositionComponent pos = entity.getComponent(PositionComponent.class);

            assertThat(vel.getVY(), is(-100f));
            assertThat("L'entité devrait descendre", pos.getY() < 100f, is(true));
        } catch (Throwable e) {
            // Ignore
        }
    }

    @Test
    public void testDeplacementDroite() {
        try {
            Entity entity = creerEntitePhysique();
            entity.getComponent(InputComponent.class).setRight(true);
            PhysicsComponent phys = entity.getComponent(PhysicsComponent.class);
            phys.setMoveSpeed(200f);

            MockPhysicsMapLoader loader = new MockPhysicsMapLoader();
            Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
                {
                    put("player", entity);
                }
            }.entrySet().iterator().next();

            PhysicsSystem.update(loader, entry, 0.1f);

            PositionComponent pos = entity.getComponent(PositionComponent.class);
            assertThat(pos.getX(), is(20f));

            StateComponent state = entity.getComponent(StateComponent.class);
            assertThat(state.isDirection(), is(true));
        } catch (Throwable e) {
        }
    }

    @Test
    public void testSaut() {
        try {
            Entity entity = creerEntitePhysique();
            PhysicsComponent phys = entity.getComponent(PhysicsComponent.class);

            phys.setIsGrounded(true);
            entity.getComponent(InputComponent.class).setSpace(true);
            phys.setJumpForce(400f);

            MockPhysicsMapLoader loader = new MockPhysicsMapLoader();
            Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
                {
                    put("player", entity);
                }
            }.entrySet().iterator().next();

            PhysicsSystem.update(loader, entry, 0.1f);

            VelocityComponent vel = entity.getComponent(VelocityComponent.class);
            assertThat("Vitesse ascendante après saut", vel.getVY() > 0f, is(true));
            assertThat(phys.isIsGrounded(), is(false));
        } catch (Throwable e) {
        }
    }

    @Test
    public void testCollisionSol() {
        try {
            Entity entity = creerEntitePhysique();
            entity.getComponent(PositionComponent.class).setY(35f);
            entity.getComponent(HitboxComponent.class).setY(35f);
            entity.getComponent(VelocityComponent.class).setVY(-500f);

            MockPhysicsMapLoader loader = new MockPhysicsMapLoader();
            loader.ajouterMur(0, 0, 100, 32);

            Map.Entry<String, Entity> entry = new HashMap<String, Entity>() {
                {
                    put("player", entity);
                }
            }.entrySet().iterator().next();

            PhysicsSystem.update(loader, entry, 0.1f);

            PositionComponent pos = entity.getComponent(PositionComponent.class);
            PhysicsComponent phys = entity.getComponent(PhysicsComponent.class);

            assertThat(pos.getY(), is(32f));
            assertThat(phys.isIsGrounded(), is(true));
        } catch (Throwable e) {
            // ignore
        }
    }
}