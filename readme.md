## GDScript plugin for IntelliJ IDEA [![Build Status][build-badge]][build-url] [![License][license-badge]](license)

![Screenshot][screenshot]

### Key Features

* Run scene / project
* Syntax highlighting
* Code completion
  * Godot Engine built-in classes, functions, constants and static methods
  * Path to file completion
* Code folding (auto-insertion)
* Paired symbols highlighting
* Commenting
* Syntax-aware code selection

Works with all IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew buildPlugin` - build plugin. Outputs `build/distributions/intellij-gdscript.zip`.
* `./gradlew publishPlugin` - publish plugin. Requires JetBrains Permanent Token located in `gradle.properties`.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required after changing ANTLR sources.
* `./gradlew generateCompletion` - generate completion JSON. Outputs `src/main/resources/completion.json`.
* `./gradlew generateLexer` - generate ANTLR lexer with language-level functions.
* `./gradlew test` - run all tests.

### Manual Installation

1. Run `./gradlew buildPlugin` or [download][plugin-url].
1. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
1. Find `build/distributions/intellij-gdscript.zip` (or downloaded file) and restart IDE.

**Contributions are welcome!**

[screenshot]: https://i.imgur.com/WLLXkf4.png
[obtain-token]: https://www.jetbrains.com/help/hub/Manage-Permanent-Tokens.html
[plugin-url]: https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
