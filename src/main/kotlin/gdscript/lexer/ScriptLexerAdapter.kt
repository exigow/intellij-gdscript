package gdscript.lexer

import com.intellij.lexer.FlexAdapter
import gdscript.parser._ScriptLexer

class ScriptLexerAdapter : FlexAdapter(_ScriptLexer(null))