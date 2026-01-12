<h2>Game engine for Platformer</h2>

\> [Home](../../../README.md)

\> Previous : [*Java Documentation*](./javadoc.md)

### Documentation : *Resources*

This section details the graphical resources used and how they are structured to be exploited by the engine via Tiled.

#### Graphical Resources
* **Player Sprites (Santa)**: A set of pixel art textures representing the main character.
    > `assets/textures/player/santa_[STATE]_[i].png`
* **Tileset**: A sheet of **32x32 pixel** tiles including the different ground blocks used in the maps.
    > `assets/textures/decor/Sol/[i].png`
* **Scenery**: Background textures used to decorate the levels; the background (forest + sky) is on a separate layer so it does not interfere with the "Sol" collisions.
    > `assets/texture/decor/BG/BG.png`

#### Configuration in Tiled
The engine uses `.tmx` files to link assets to the game logic:
* **Collision Layer ("Sol")**: This layer groups the tiles that the engine automatically transforms into solid objects for the physics system.
* **Object Layer**: 
    * **Start**: A marker used to define the precise spawn point of the player.
    * **End**: A detection zone that triggers the end of the level.
    * **Walls**: Invisible objects placed at the map boundaries to block the player and stop the camera.

<br>

\> Next : [*End*](../../../README.md)
