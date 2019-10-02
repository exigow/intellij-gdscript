package config

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import config.grammar.ConfigLexer
import config.grammar.ConfigLexer.*
import config.grammar.ConfigParser
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory.createTokenSet
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ConfigParserDefinition : ParserDefinition {

    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(ConfigLanguage, ConfigParser.tokenNames, ConfigParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer {
        val lexer = ConfigLexer(null)
        return ANTLRLexerAdaptor(ConfigLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = ConfigParser(null)
        return object : ANTLRParserAdaptor(ConfigLanguage, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is ConfigParser)
                require(root is IFileElementType)
                return parser.file()
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = createTokenSet(ConfigLanguage, WHITESPACE)

    override fun getCommentTokens(): TokenSet = createTokenSet(ConfigLanguage, LINE_COMMENT)

    override fun getStringLiteralElements(): TokenSet = createTokenSet(ConfigLanguage, STRING)

    override fun getFileNodeType() = IFileElementType(ConfigLanguage)

    override fun createFile(viewProvider: FileViewProvider) = ConfigFileBase(viewProvider)

    override fun createElement(node: ASTNode) = ANTLRPsiNode(node)

}
