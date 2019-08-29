package gdscript.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import gdscript.GDScriptLanguage
import gdscript.grammar.GDScriptLexer
import gdscript.grammar.GDScriptLexer.*
import gdscript.grammar.GDScriptParser
import gdscript.psi.PsiFileBase
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ParserDefinition : com.intellij.lang.ParserDefinition {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(GDScriptLanguage, GDScriptParser.tokenNames, GDScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = GDScriptLexer(null)
        return ANTLRLexerAdaptor(GDScriptLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = GDScriptParser(null)
        return object : ANTLRParserAdaptor(GDScriptLanguage, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is GDScriptParser)
                return if (root is IFileElementType) parser.file() else TODO("Unsupported non-file root!")
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = createTokenSet(GDScriptLanguage, WHITESPACE)

    override fun getCommentTokens(): TokenSet = createTokenSet(GDScriptLanguage, LINE_COMMENT, BLOCK_COMMENT)

    override fun getStringLiteralElements(): TokenSet = createTokenSet(GDScriptLanguage, STRING)

    override fun getFileNodeType() = IFileElementType(GDScriptLanguage)

    override fun createFile(viewProvider: FileViewProvider) = PsiFileBase(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        return ANTLRPsiNode(node)
    }

}
