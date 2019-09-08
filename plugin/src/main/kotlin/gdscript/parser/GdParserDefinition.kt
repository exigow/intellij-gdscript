package gdscript.parser

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
import gdscript.GdLanguage
import gdscript.grammar.GDScriptLexer
import gdscript.grammar.GDScriptLexer.*
import gdscript.grammar.GDScriptParser
import gdscript.psi.GdFileBase
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class GdParserDefinition : ParserDefinition {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(GdLanguage, GDScriptParser.tokenNames, GDScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = GDScriptLexer(null)
        return ANTLRLexerAdaptor(GdLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = GDScriptParser(null)
        return object : ANTLRParserAdaptor(GdLanguage, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is GDScriptParser)
                require(root is IFileElementType)
                return parser.file()
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = createTokenSet(GdLanguage, WHITESPACE)

    override fun getCommentTokens(): TokenSet = createTokenSet(GdLanguage, LINE_COMMENT, BLOCK_COMMENT)

    override fun getStringLiteralElements(): TokenSet = createTokenSet(GdLanguage, STRING)

    override fun getFileNodeType() = IFileElementType(GdLanguage)

    override fun createFile(viewProvider: FileViewProvider) = GdFileBase(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        return ANTLRPsiNode(node)
    }

}
