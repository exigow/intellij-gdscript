package script.adaptors

import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import script.ScriptLanguage
import script.grammar.ScriptLexer

class LexerAdaptor : ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))