package plugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import plugin.parser.GDScriptLexer
import plugin.parser.GDScriptParser
import plugin.psi.GDScriptPsiFileRoot

class GDScriptParserDefinition : ParserDefinition {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(GDScript, GDScriptParser.tokenNames, GDScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = GDScriptLexer(null)
        return ANTLRLexerAdaptor(GDScript, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = GDScriptParser(null)
        return object : ANTLRParserAdaptor(GDScript, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is GDScriptParser)
                return if (root is IFileElementType) parser.script() else parser.primary()
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = PSIElementTypeFactory.createTokenSet(GDScript, GDScriptLexer.WHITESPACE)

    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun getFileNodeType() = IFileElementType(GDScript)

    override fun createFile(viewProvider: FileViewProvider) = GDScriptPsiFileRoot(viewProvider)

    override fun createElement(node: ASTNode): PsiElement = ANTLRPsiNode(node)

}
