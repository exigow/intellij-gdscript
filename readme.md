# Godot GDScript plugin for the IntelliJ Platform

[![Travis Build Status][travis-build-status-svg]][travis-build-status]

Plugin is compatible with **any** product developed by JetBrains based on the IntelliJ Platform (*IntelliJ IDEA*, *Android Studio*, *PyCharm*, *CLion*, and so on).

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin.
* `./gradlew generateGrammarSource` - generate lexer/parser from ANTLR grammar sources.
* `./gradlew test` - run plugin tests.
* `./gradlew updateCompletion` - update completion data using [documentation sources](https://github.com/godotengine/godot/tree/master/doc/classes).

## Manual installation

1. Run `./gradlew buildPlugin` to create `plugin.zip` archive.
2. Start IntelliJ, open `Preferences`, section `Plugins`, find :gear: icon, option `Install plugin from disk...`.
4. Open `<PROJECT>/plugin/build/distributions/plugin.zip` archive.
3. Restart IntelliJ.

[travis-build-status]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[travis-build-status-svg]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master