package gdscript

import gdscript.adaptors.CommenterAdaptor

class ScriptCommenter : CommenterAdaptor(
    linePrefix = "#",
    blockPrefix = MULTILINE_STRING_MARKER,
    blockPostfix = MULTILINE_STRING_MARKER
) {
    companion object {
        const val MULTILINE_STRING_MARKER = "\"\"\""
    }
}