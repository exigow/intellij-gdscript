# GDScript plugin for the IntelliJ Platform

![Travis (.org)](https://img.shields.io/travis/exigow/intellij-gdscript) ![GitHub](https://img.shields.io/github/license/exigow/intellij-gdscript)

## Usage

* `./gradlew :plugin:runIde` - run sandbox with installed plugin.
* `./gradlew :plugin:buildPlugin` - create plugin archive (required for manual installation).
* `./gradlew :api:run` - update completion JSON using [Godot API sources](https://github.com/godotengine/godot/tree/master/doc/classes).

## Manual installation

1. Run `./gradlew :plugin:buildPlugin`.
2. Start IntelliJ, open `Preferences`, section `Plugins`, choose `Install plugin from disk...` and navigate to `<PROJECT>/plugin/build/distributions/plugin.zip`.
3. Restart IntelliJ.
