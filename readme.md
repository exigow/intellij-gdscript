# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

Works with all IntelliJ-based IDEs starting from **2019.3**. List of available features is [here](src/main/resources/META-INF/plugin.xml).

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin
* `./gradlew test` - run all tests
* `./gradlew buildPlugin` - build plugin distribution to `build/distributions/intellij-gdscript.zip`
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository

### How to update completion data

1. Install Godot Engine or build from sources
2. Export XML classes with `godot --doctool .`
3. Compress these classes into `3.2.2-stable.zip` (example name; structure is not important)
4. Save file inside `src/main/resources/version/` directory
5. Update [sources](src/main/kotlin/version/VersionService.kt)

New API version will be available in *Settings* | *Languages & Frameworks* | *GDScript*

### How to update grammars with Grammar-Kit plugin

* To update parser use *Generate Parser Code* option on `.bnf` file
* To update lexer use *Run JFlex Generator* option on `.flex` file

### How to install plugin manually

1. Build plugin from sources, download [latest stable version](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or any [GitHub Actions artifact](https://github.com/exigow/intellij-gdscript/actions)
1. Navigate to: *Settings* | *Plugins* | :gear: | *Install plugin from disk...*
