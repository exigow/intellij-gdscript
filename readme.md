# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

## Features

* Syntax highlighting
* Code completion
* `res://` completion
* Syntax-aware code selection
* Run scene
* LSP support (experimental)

Works with all IntelliJ-based IDEs starting from v2019.3.

## Usage & Development

* `./gradlew buildPlugin` - build plugin distribution to `build/distributions/intellij-gdscript.zip`
* `./gradlew runIde` - run sandbox with installed plugin
* `./gradlew test` - run all tests
* `./gradlew generateCompletion` - generate Godot Engine API completion file
* `./gradlew downloadDocumentation` - scrape documentation XML files from Godot Engine GitHub repository
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository

## Manual Installation

1. Download [official release](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or latest [build artifact](https://github.com/exigow/intellij-gdscript/actions) *(recommended)*.
1. Start IDE, navigate to `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
1. Find file and restart IDE.

## Enabling LSP features

Contextual completion and warnings are **disabled** by default due to experimental status. To enable LSP-based features navigate to `Settings` | `Languages & Frameworks` | `GDScript`.

LSP is supported in Godot Engine since `3.2.2`.

## Contributing

Pull requests are welcome. :wave: 

For major changes, please open an issue first to discuss what you would like to change. Please make sure to update tests as appropriate.