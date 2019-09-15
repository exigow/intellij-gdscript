package gdscript

import gdscript.adaptors.CommenterAdaptor

class ScriptCommenter : CommenterAdaptor(
    linePrefix = "#",
    blockPrefix = "\"\"\"",
    blockPostfix = "\"\"\""
)