## GDScript plugin for IntelliJ IDEA [![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]](license)

![Type completion](https://i.imgur.com/hhhZFAl.png)

![File completion](https://i.imgur.com/i6u0KAD.png)

### Features

* Syntax highlighting (`.gd`, `.tres`) 
* Code completion of Godot Engine built-in classes, functions and static methods
* Path to file completion/validation 
* Auto-insertion of braces, brackets and quotes
* Code commenting (`Ctrl+/`)
* Syntax-aware code selection (`Ctrl+W` / `Ctrl+Shift+W`)
* Paired brackets highlighting

Works with all IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

* `./gradlew runIde` - run sandbox IDE with installed plugin. First run may take a while.
* `./gradlew buildPlugin` - build plugin. Outputs `build/distributions/intellij-gdscript.zip`.
* `./gradlew publishPlugin` - publish plugin. Requires JetBrains Permanent Token located in `gradle.properties`.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required after changing ANTLR sources.
* `./gradlew generateCompletion` - download & generate completion. Outputs `src/main/resources/completion.json`.
* `./gradlew test` - run all tests.

### Manual Installation

1. Run `./gradlew buildPlugin` or [download][plugin-url].
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` (or downloaded file) and restart IDE.

**Contributions are welcome!**

[obtain-token]: https://www.jetbrains.com/help/hub/Manage-Permanent-Tokens.html
[plugin-url]: https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
