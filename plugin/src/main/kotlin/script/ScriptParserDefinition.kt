package script

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import script.grammar.ScriptLexer
import script.grammar.ScriptLexer.*
import script.grammar.ScriptParser
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ScriptParserDefinition : ParserDefinition {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, ScriptParser.tokenNames, ScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = ScriptLexer(null)
        return ANTLRLexerAdaptor(ScriptLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = ScriptParser(null)
        return object : ANTLRParserAdaptor(ScriptLanguage, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is ScriptParser)
                require(root is IFileElementType)
                return parser.file()
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = createTokenSet(ScriptLanguage, WHITESPACE)

    override fun getCommentTokens(): TokenSet = createTokenSet(ScriptLanguage, LINE_COMMENT)

    override fun getStringLiteralElements(): TokenSet = createTokenSet(ScriptLanguage, STRING)

    override fun getFileNodeType() = IFileElementType(ScriptLanguage)

    override fun createFile(viewProvider: FileViewProvider) = ScriptFileBase(viewProvider)

    override fun createElement(node: ASTNode) = ANTLRPsiNode(node)

}
