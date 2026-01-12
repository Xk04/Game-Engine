<h2>Game engine for Platformer</h2>

\> [Home](../../../README.md)

\> Previous : [*Presentation*](./presentation.md)

### Presentation : *Objectives for the game engine*


When we did this project, firstly our goal was to create a scalable project, easy to maintain.  
That's why we used some design patterns, and why we did some choices we will explain later. 

</br>

Which choices ?  

Choices that allow us (or anybody who use the engine) to add any features we want.  
For instance, if tomorrow we want to add a new behavior for ennemies we (and you) can do it easily.  
Then we have to update anything we need in a concrete level : the instantiation of entities, map, behaviors, ...

</br>

What kind of choices ?  

    For models (data containers) : 
    - Entity / Components
    - Entity Factory

</br>

    For controllers :
    - Mediator (the manager of manager)
    - Iterator (level manager)

</br>

    For view :
    - The creation of view managers (ex: texture manager) in order to simplified the renderers.
    - The separation of the main rendering into several renderings 
      |--> the idea is to separate each element to interpret clearly each rendering.

This page is not an enamuration of all choices we did in the project but an idea.  
For more informations on these components, we advise you to check the **architecture part**.


</br>

\> Next : [*Technologies used*](./technologies.md)