# GDScript plugin for the IntelliJ Platform

![Travis (.org)](https://img.shields.io/travis/exigow/intellij-gdscript)
![GitHub](https://img.shields.io/github/license/exigow/intellij-gdscript)

## Usage

* `./gradlew :plugin:runIde` - run sandbox with installed plugin.
* `./gradlew :plugin:buildPlugin` - create plugin archive `plugin/build/distributions/plugin.zip` (required for [manual installation](https://www.jetbrains.com/help/idea/managing-plugins.html#install_plugin_from_disk).
* `./gradlew :api:run` - update completion JSON using [Godot API sources](https://github.com/godotengine/godot/tree/master/doc/classes).

