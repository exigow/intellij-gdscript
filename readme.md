# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

## Features

* Syntax highlighting
* Code completion
* `res://` completion
* Syntax-aware code selection
* Run scene

Works with all IntelliJ-based IDEs starting from v2019.3.

## Usage & Development

* `./gradlew buildPlugin` - build plugin distribution to `build/distributions/intellij-gdscript.zip`
* `./gradlew runIde` - run sandbox with installed plugin
* `./gradlew test` - run all tests
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository

### How to update/add completion data

1. Export API with `godot --doctool .`
1. Compress doc files into single `3.2.2-stable.zip` (example name; structure is not important)
1. Save file as `src/main/resources/version/3.2.2-stable.zip`
1. Update [sources](src/main/kotlin/version/VersionService.kt) 

New API version will be available in `Settings` | `Languages & Frameworks` | `GDScript`

### How to regenerate lexer/parser

Requirements: IDE with installed **Grammar Kit** plugin

1. Right-Click on `TscnParser.bnf` -> `Generate JFlex Lexer`
1. Right-Click on `TscnParser.bnf` -> `Generate Parser Code` (2x for two-pass generation)
1. Right-Click on `_TscnParser.flex` -> `Run JFlex Generator`

## Manual Installation

1. Download [official release](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or latest [build artifact](https://github.com/exigow/intellij-gdscript/actions) *(recommended)*.
1. Start IDE, navigate to `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
1. Find file and restart IDE.

## Contributing

Pull requests are welcome. :wave: 

For major changes, please open an issue first to discuss what you would like to change. Please make sure to update tests as appropriate.