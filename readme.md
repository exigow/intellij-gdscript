## GDScript plugin for IntelliJ IDEA

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]](license) 

![Type completion](https://i.imgur.com/hhhZFAl.png)
![File completion](https://i.imgur.com/i6u0KAD.png)
![Null keyword completion](https://i.imgur.com/NsQ3QWI.png)

### Features

* Syntax highlighting
  GDScript and scene files highlighting. Paired brackets highlighting.
* Code completion
  Godot Engine built-in classes, functions and static methods completion.
* Import file completion
  Path to class or project file completion. 
* Code folding
  Auto-insertion of braces, brackets and quotes.
* Code commenting
  `Ctrl+/` to comment or uncomment selection.
* Code selection
  Syntax-aware selection. `Ctrl+W` to expand, `Ctrl+Shift+W` to shrink.

### Installation

1. Run `./gradlew buildPlugin` or [download latest release][plugin-url].
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` (or downloaded file) and restart.

Plugin is compatible with all IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

Contributions are welcome!

* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required to update changes in ANTLR sources (`src/main/antlr/*.g4`).
* `./gradlew generateCompletion` - download & generate completion  `src/main/resources/completion.json`.
* `./gradlew test` - run all tests.

[plugin-url]: https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
