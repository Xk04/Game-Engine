<div>
<h1 align="center">University of Nice Côte d'Azur</h1>
<h2>Game Engine for Platformer</h2>
<h3>Maxime Santarelli & Reese Dode & Irakly Tevdoradze</h3>
</div>

<br>

## Summary

> ### Presentation

- [Presentation](docs/doc_files/presentation/presentation.md)
- [Objectives for the game engine](docs/doc_files/presentation/objectives.md)
- [Technologies used](docs/doc_files/presentation/technologies.md)
- [Features enabled](docs/doc_files/presentation/features.md)
- [How to use the project ?](docs/doc_files/presentation/continue.md)

<br>


> ### Architecture

- [General Structure](docs/doc_files/architecture/general_structure.md)
- [Model](docs/doc_files/architecture/model.md)
- [View](docs/doc_files/architecture/view.md)
- [Controller](docs/doc_files/architecture/controller.md)
- [Overall UML](docs/doc_files/architecture/overall_uml.md)

<br>


> ### Documentation

- [Java Documentation](docs/doc_files/documentation/javadoc.md)
- [Resources](docs/doc_files/documentation/assets.md)

<br>

> ### Tests

- [Tests Documentation](docs/doc_files/test/test.md)

<br>

> ### Examples

- [Images of the game engine](docs/doc_files/examples/images.md)

<br>


> ### About LibGDX and Gradle uses

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

### Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.

### Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
