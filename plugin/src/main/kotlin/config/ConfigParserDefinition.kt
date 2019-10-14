package config

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import config.grammar.ConfigLexer
import config.grammar.ConfigParser
import config.psi.PsiFile
import config.psi.TokenSet.LINE_COMMENT
import config.psi.TokenSet.STRING
import config.psi.TokenSet.WHITESPACE
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ConfigParserDefinition : ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ConfigLanguage, ConfigParser.tokenNames, ConfigParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(ConfigLanguage, ConfigLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(ConfigLanguage, ConfigParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as ConfigParser).file()
        }

    override fun getWhitespaceTokens() = WHITESPACE

    override fun getCommentTokens() = LINE_COMMENT

    override fun getStringLiteralElements() = STRING

    override fun getFileNodeType() = IFileElementType(ConfigLanguage)

    override fun createFile(viewProvider: FileViewProvider) = PsiFile(viewProvider)

    override fun createElement(node: ASTNode) = ANTLRPsiNode(node)

}
