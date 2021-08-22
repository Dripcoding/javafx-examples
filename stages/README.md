Stages

- top-most container that holds the entire FX application ("the Window")

The FX GUI
- comprised of multiple layers  
    - stage - top-most container
    - scene - drawing surface for graphical content
    - scene-graph - tree of ui components that has 1 root node

Starting the application
- create a root node
- create a scene with a root node
- set the stage with the scene
- show the stage

Q: Why does the order of setting root, scene, and stage matter?
A: This ensures the scene resizes correctly with the stage

Stage Options
- Stage has various settings and default behaviors that you can override
