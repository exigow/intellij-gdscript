# GDScript plugin for the IntelliJ Platform

Work in progress.

## Installation & Usage

`gradle runIde` to execute IntelliJ IDEA instance with installed GDScript plugin.

NOTE: the first start may take a while.

## Features (strikethrough = TODO)

* `.gd` file recognition
* Syntax highlighting
  * Keywords
  * Literals
  * ~~Class variables~~
  * ~~Class constants~~
* Code completion:
  * Built-In classes/primitives (e.g. `Vector2`, `float`, `Node`, `VisualShaderNodeTextureUniformTriplanar`)
  * Built-In methods/functions (e.g. `cos`, `deg2rad`)
  * Built-In constants with value lookups
  * Return type lookups
  * ~~Context-aware completion~~
  * ~~~~
* Comment shortcuts (<kbd>ctrl</kbd> + <kbd>/</kbd> or <kbd>ctrl</kbd> + <kbd>shift</kbd> + <kbd>/</kbd>)
* ~~Recognize `.import` file~~
