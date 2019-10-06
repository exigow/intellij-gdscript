# GDScript plugin for the IntelliJ Platform

![Travis (.org)](https://img.shields.io/travis/exigow/intellij-gdscript) ![GitHub](https://img.shields.io/github/license/exigow/intellij-gdscript)

## Usage & Development

* `./gradlew :plugin:runIde` - run sandbox with installed plugin.
* `./gradlew :plugin:generateGrammarSource` - generate lexer/parser from ANTLR grammar sources.
* `./gradlew :plugin:test` - run plugin tests.
* `./gradlew :api:run` - generate completion data using [Godot API sources](https://github.com/godotengine/godot/tree/master/doc/classes).

## Manual installation

1. Run `./gradlew :plugin:buildPlugin` to create `plugin.zip` archive.
2. Start IntelliJ, open `Preferences`, section `Plugins`, :gear: icon, choose `Install plugin from disk...`.
4. Open `<PROJECT>/plugin/build/distributions/plugin.zip` archive.
3. Restart IntelliJ.
