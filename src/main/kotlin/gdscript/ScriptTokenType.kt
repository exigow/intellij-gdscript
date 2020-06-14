package gdscript

import com.intellij.psi.tree.IElementType

object ScriptTokenType {

    val KEYWORD = IElementType("KEYWORD", ScriptLanguage)

    val CLASS_NAME = IElementType("CLASS_NAME", ScriptLanguage)

    val DOUBLE_QUOTED_STRING = IElementType("DOUBLE_QUOTED_STRING", ScriptLanguage)
    val SINGLE_QUOTED_STRING = IElementType("SINGLE_QUOTED_STRING", ScriptLanguage)

    val NUMBER = IElementType("NUMBER", ScriptLanguage)
    val IDENTIFIER = IElementType("IDENTIFIER", ScriptLanguage)
    val NODE = IElementType("NODE", ScriptLanguage)
    val CONSTANT = IElementType("CONSTANT", ScriptLanguage)
    val LINE_COMMENT = IElementType("LINE_COMMENT", ScriptLanguage)
    val WHITESPACE = IElementType("WHITESPACE", ScriptLanguage)

    val END_OF_LINE = IElementType("END_OF_LINE", ScriptLanguage)

    val COMMA = IElementType("COMMA", ScriptLanguage)
    val ARROW = IElementType("ARROW", ScriptLanguage)
    val COLON = IElementType("COLON", ScriptLanguage)
    val SEMICOLON = IElementType("SEMICOLON", ScriptLanguage)
    val DOT = IElementType("DOT", ScriptLanguage)

    val BRACE_LEFT = IElementType("BRACE_LEFT", ScriptLanguage)
    val BRACE_RIGHT = IElementType("BRACE_RIGHT", ScriptLanguage)
    
    val BRACKET_LEFT = IElementType("BRACKET_LEFT", ScriptLanguage)
    val BRACKET_RIGHT = IElementType("BRACKET_RIGHT", ScriptLanguage)
    
    val PARENTH_LEFT = IElementType("PARENTH_LEFT", ScriptLanguage)
    val PARENTH_RIGHT = IElementType("PARENTH_RIGHT", ScriptLanguage)
    
    val UNRECOGNIZED = IElementType("UNRECOGNIZED", ScriptLanguage)

}
