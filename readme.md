# Godot GDScript plugin for the IntelliJ Platform

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]][license-url]

![Code Completion](https://i.imgur.com/GC8K52X.png)

Plugin is compatible with all products developed by JetBrains (*IntelliJ IDEA*, *Android Studio*, *PyCharm*, *CLion*, ...).

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin.
* `./gradlew test` - run plugin tests.
* `./gradlew generateGrammarSource` - generate lexer/parser from ANTLR grammar sources.
* `./gradlew generateCompletion` - generate completion data.

## Manual installation

1. Run `./gradlew buildPlugin` or [download plugin][plugin-url].
2. Start IntelliJ, open `Preferences`, section `Plugins`, :gear:, option `Install plugin from disk...`.
4. Open `build/distributions/plugin.zip` archive.
3. Restart IntelliJ.

[plugin-url]: https://plugins.jetbrains.com/plugin/13107
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
[license-url]: https://github.com/exigow/intellij-gdscript/blob/master/license
