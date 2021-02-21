package gdscript.lexer

import com.intellij.lexer.FlexAdapter

class ScriptLexerAdapter : FlexAdapter(ScriptLexer(null))