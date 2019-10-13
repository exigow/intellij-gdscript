# Godot GDScript plugin for the IntelliJ Platform

[![Travis Build Status][travis-build-badge]][travis-build-link]
[![GitHub License][github-license-badge]][github-license-link]

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

[travis-build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[travis-build-link]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[github-license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
[github-license-link]: https://github.com/exigow/intellij-gdscript/blob/master/license
