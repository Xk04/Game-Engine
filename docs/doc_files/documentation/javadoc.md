<h2>Game engine for Platformer</h2>

\> [Home](../../../README.md)

\> Previous : [_Overall UML_](../architecture/overall_uml.md)

### Documentation : _Java Documentation_

This project uses **Javadoc** to document the source code (classes, methods, and parameters).

#### Where can I see the java documentation ?

You need to select the `/docs/javadoc/index.html` file of the project to open the detailed documentation of classes

#### How to generate Javadoc

The project uses **Gradle** to automate the generation of the documentation. To generate the HTML reports, run the command in your terminal at the root of the project:

> ```bash
> ./gradlew javadoc
> ```

**Note on Execution Rights**:
If you encounter a `permission denied` error (common on macOS or Linux) while running the Gradle script, you must grant it execution rights with the following command:

> ```bash
> chmod +x gradlew
> ```


\> Next : [*End*](../../../README.md)
