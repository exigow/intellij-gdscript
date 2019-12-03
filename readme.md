## GDScript plugin for IntelliJ IDEA

[![Travis Build Status][build-badge]][build-url] [![GitHub License][license-badge]](license) 

![Type completion](https://i.imgur.com/hhhZFAl.png)

### Features

* Syntax highlighting (`.gd`, `.tres`) 
* Code completion of Godot Engine built-in classes, functions and static methods
* Path to file completion/validation 
* Auto-insertion of braces, brackets and quotes
* Code commenting (`Ctrl+/`)
* Syntax-aware code selection (`Ctrl+W` / `Ctrl+Shift+W`)
* Paired brackets highlighting

### Installation

1. Run `./gradlew buildPlugin` or [download latest release][plugin-url].
2. Start IntelliJ, open `Settings` | `Plugins` | :gear: | `Install plugin from disk...`.
3. Find `build/distributions/intellij-gdscript.zip` (or downloaded file) and restart.

Plugin is compatible with all IntelliJ-based IDEs starting from v2019.2.

### Usage & Development

**Contributions are welcome!**

* `./gradlew runIde` - run sandbox with installed plugin. First run may take a while.
* `./gradlew generateGrammarSource` - re-generate lexer and parser Java code. Required to update changes in ANTLR sources (`src/main/antlr/*.g4`).
* `./gradlew generateCompletion` - download & generate completion  `src/main/resources/completion.json`.
* `./gradlew test` - run all tests.

#### Publishing

You have to [obtain authentication token][obtain-token] in order to push distribution into JetBrains plugin repository.
Token is located in `gradle.properties` file with `publishPluginToken` key (empty value by default).

```shell script
./gradlew publishPlugin
```

NOTE: To ignore changes in `gradle.properties` use `git update-index --assume-unchanged gradle.properties`.

### Screenshots

![File completion](https://i.imgur.com/i6u0KAD.png)

![Missing file warning](https://i.imgur.com/OKM93A9.png)

![Null keyword completion](https://i.imgur.com/NsQ3QWI.png)

![Constant value lookups like PI](https://i.imgur.com/aFmZW8B.png)

![Class name completion](https://i.imgur.com/5j9MzWO.png)

More screenshots can be found [on imgur](https://exigow.imgur.com/all).

[obtain-token]: https://www.jetbrains.com/help/hub/Manage-Permanent-Tokens.html
[plugin-url]: https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions
[build-badge]: https://travis-ci.org/exigow/intellij-gdscript.svg?branch=master
[build-url]: https://travis-ci.org/exigow/intellij-gdscript?branch=master
[license-badge]: https://img.shields.io/github/license/exigow/intellij-gdscript?branch=master
