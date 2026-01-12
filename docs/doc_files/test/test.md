<h2>Game engine for Platformer</h2>

\> [Home](../../../README.md)

### Tests : *Tests Documentation*


To carry out the tests, we used JUnit to structure the tests and Hamcrest to provide more readable and understandable assertions. All tests can be launched simply with the `"./gradlew test"` command, which runs everything automatically: either everything passes without displaying anything special in the terminal, or detailed error messages are shown to help understand what went wrong. An HTML report is also generated to provide a clear overview of the results, accessible at `"core/build/reports/tests/test/index.html"`.



#### 1. Controllers and Level Management

>

    InputManagerTest: Verifies that the keys (Q, D, Z, Space) trigger the correct actions and properly handle unknown keys.

    LevelManagerTest: Tests the level chaining and verifies that the game correctly starts on StartingPoint.

    LevelTest: Secures the level base by forbidding empty or null map paths.

    Level1 / 2 / 3 & StartingPointTest: Validates that each level loads its own .tmx file and correctly stores its entities.

    GameEngineTest: Ensures that the engine properly initializes all managers (Level, Input, World) at startup.




#### 2. Entity Components (Data)

>
    PositionComponentTest: Verifies the storage of X/Y coordinates, including negative values.

    VelocityComponentTest: Tests horizontal and vertical velocity vectors.

    PhysicsComponentTest: Checks the base constants (gravity at -1000, speed at 180, jump force at 400).

    HitboxComponentTest: Validates the creation of the collision rectangle and its update during movement.

    HealthComponentTest: Manages health points (HP) and minimum/maximum limits.

    SpriteComponentTest: Ensures that the entity image path is valid and non-empty.

    StateComponentTest: Manages states (idle, run, jump) and facing direction (left/right).

    AnimationComponent & AnimInfoTest: Test the storage of image folders and animation playback speed.

    InputComponentTest: Verifies the logical state (true/false) of entity commands.

 


#### 3. Systems and Logic (Calculations)

>
    PhysicsSystemTest: The core of physics. Tests falling (gravity), jumping, and an immediate stop upon contact with a solid block.

    CollisionSystemTest: Manages game rules. Tests whether the player wins (end zone) or dies by falling (respawn if Y < -300).

    AnimationSystemTest: Verifies that textures change over time to create movement.


#### 4. Factories and World

>
    PlayerFactoryTest: Verifies that a created player has all mandatory components (Physics, Hitbox, etc.).

    Enemy / Coin / EntityFactoryTest: Tests the creation structure of enemies and objects (currently in placeholder mode).

    EntityTest: Validates that components can be added, retrieved, or modified on any entity.

    GameWorldTest: Tests adding and removing entities from the global world list.

    MapLoaderTest: Verifies the extraction of map data (spawn points and collision zones).



#### 5. Entry Point

    MainTest: Ensures that the LibGDX application can be created and launched (render) without crashing.

<br>
<br>

\> Previous : [*Resources*](../documentation/assets.md)

\> Next : [*Images of the game engine*](../examples/images.md)