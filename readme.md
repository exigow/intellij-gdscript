# Godot GDScript plugin for the IntelliJ Platform

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]][license-url]

![Type completion](https://i.imgur.com/502twEt.png)

## Installation

1. Run `./gradlew buildPlugin`.
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` and restart.

Plugin is compatible with all IntelliJ-based IDEs starting from v2019.2.

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin (first run may take a while).
* `./gradlew test` - run all tests.
* `./gradlew generateGrammarSource` - generate lexer/parser sources.
* `./gradlew generateCompletion` - generate completion data.

## Screenshots

![Language-level functions completion](https://i.imgur.com/rD7deeO.png)
![Resource file completion](https://i.imgur.com/L98tSSA.png)
![Global constant completion](https://i.imgur.com/i2UYKFc.png)
![Class constant completion](https://i.imgur.com/UQG7NoZ.png)
![Dictionary key highlighting](https://i.imgur.com/oAifVEr.png)
![JSON file completion](https://i.imgur.com/vDtcev8.png)

[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
[license-url]: https://github.com/exigow/intellij-gdscript/blob/master/license
