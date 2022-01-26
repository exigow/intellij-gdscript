# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

Works with all IntelliJ-based IDEs starting from **2019.3**. List of available features is [here](src/main/resources/META-INF/plugin.xml).

## Usage & Development

* `./gradlew runIde` - run sandbox with installed plugin
* `./gradlew test` - run all tests
* `./gradlew buildPlugin` - build plugin distribution to `build/distributions/intellij-gdscript.zip`
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository

### How to update completion data

You need to clone the Godot Engine repository and pack the class definitions into ZIP file. Such file must be placed inside plugin `resources`. ZIP structure is not important.

The following commands describes how to update version `3.4` from project directory perspective:

1. `git clone --branch 3.4 https://github.com/godotengine/godot.git --depth 1`
2. `zip -r 3.4.zip ./godot/doc/classes/ ./godot/modules/gdscript/doc_classes/@GDScript.xml`
3. `rm -rf godot/`
4. `mv -f 3.4.zip src/main/resources/version/`

New API version will be available in *Settings* | *Languages & Frameworks* | *GDScript*

### How to update grammars with Grammar-Kit plugin

* To update parser use *Generate Parser Code* option on `.bnf` file
* To update lexer use *Run JFlex Generator* option on `.flex` file

### How to install plugin manually

1. Build plugin from sources, download [latest stable version](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or any [GitHub Actions artifact](https://github.com/exigow/intellij-gdscript/actions)
1. Navigate to: *Settings* | *Plugins* | :gear: | *Install plugin from disk...*

### How to fix `Mixed tabs and spaces in indentation` error

To prevent mixing tabs (Godot defaults) with 4-space indents (IDE defaults), add `.editorconfig` file to your project directory:

```editorconfig
[*.gd]
indent_style = tab
```
