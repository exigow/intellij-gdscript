# GDScript plugin for IntelliJ IDEA

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]][license-url] 

Plugin that implements GDScript (`.gd`) and Godot project files (`.tscn`) support for IntelliJ Platform, featuring:

* Type completion

![](https://i.imgur.com/hhhZFAl.png)

* Project File completion

![](https://i.imgur.com/i6u0KAD.png)

* Language Built-In Keywords, Functions and Classes completion 

![](https://i.imgur.com/NsQ3QWI.png)

# Installation

1. Run task `./gradlew buildPlugin` or [download plugin][plugin-url].
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` (or downloaded) and restart.

Plugin is compatible with all IntelliJ-based IDEs starting from v2019.2.

## Usage & Development

Contributions are welcome!

* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required to update changes in ANTLR sources (`src/main/antlr/*.g4`).
* `./gradlew generateCompletion` - download & generate completion  `src/main/resources/completion.json`.
* `./gradlew test` - run all tests.

[plugin-url]: https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
[license-url]: https://github.com/exigow/intellij-gdscript/blob/master/license
