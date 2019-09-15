package gdscript.commenter

import gdscript.commenter.adaptors.CommenterAdaptor

class ScriptCommenter : CommenterAdaptor(
    linePrefix = "#",
    blockPrefix = "\"\"\"",
    blockPostfix = "\"\"\""
)