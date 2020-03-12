## GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

### Features

* Syntax highlighting
* Code completion
* `res://` completion
* Syntax-aware code selection
* Run scene

### Installation

1. Download the latest build artifact from the ["Build Plugin" Github Action](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22)
1. Start IntelliJ, navigate to `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
1. Find the downloaded zip file and restart IDE.

Alternatively, [download](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) latest version from official plugins repository. Release might be outdated so it's not recommended.

Plugin works with **all** IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

* `./gradlew buildPlugin` - builds the plugin distribution to `build/distributions/intellij-gdscript.zip`
* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew test` - run all tests.
* `./gradlew generateGrammarSource` - generate ANTLR lexer and parser Java class.
* `./gradlew generateCompletion` - update Godot Engine API completion file.
* `./gradlew generateLexer` - update ANTLR lexer rules with language-level functions, constants and types.
* `./gradlew downloadDocumentation` - scrape & download documentation XML files from Godot Engine GitHub repository (used for completion).
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository. Requires [token](https://www.jetbrains.com/help/hub/Manage-Permanent-Tokens.html) located in `gradle.properties`.

Issues and pull requests are welcome. :wave:
