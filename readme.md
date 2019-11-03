# Godot GDScript plugin for the IntelliJ Platform

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]][license-url]

![Type completion](https://i.imgur.com/502twEt.png)

Plugin is compatible with all products developed by JetBrains (*IntelliJ IDEA*, *Android Studio*, *PyCharm*, *CLion*, ...).

## Installation

1. Run `./gradlew buildPlugin`.
2. Start *IntelliJ*, *Settings* | *Plugins* | :gear: | *Install plugin from disk...*.
3. Find `build/distributions/intellij-gdscript.zip` and restart.

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin.
* `./gradlew test` - run plugin tests.
* `./gradlew generateGrammarSource` - generate lexer/parser from ANTLR grammar sources.
* `./gradlew generateCompletion` - generate completion data.

## Screenshots

![Class file completion](https://i.imgur.com/y5HJXxS.png)
![Language-level functions completion](https://i.imgur.com/rD7deeO.png)
![Global constant completion](https://i.imgur.com/i2UYKFc.png)
![Class constant completion](https://i.imgur.com/UQG7NoZ.png)
![JSON file completion](https://i.imgur.com/vDtcev8.png)

[plugin-url]: https://plugins.jetbrains.com/plugin/13107
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
[license-url]: https://github.com/exigow/intellij-gdscript/blob/master/license
