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
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import plugin.parser.GDScriptLanguageLexer
import plugin.parser.GDScriptLanguageParser
import plugin.psi.*

class GDScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        val lexer = GDScriptLanguageLexer(null)
        return ANTLRLexerAdaptor(GDScriptLanguage, lexer)
    }

    override fun createParser(project: Project): PsiParser {
        val parser = GDScriptLanguageParser(null)
        return object : ANTLRParserAdaptor(GDScriptLanguage, parser) {

            override fun parse(parser: Parser, root: IElementType): ParseTree {
                require(parser is GDScriptLanguageParser)
                return if (root is IFileElementType) parser.script() else parser.primary()
            }

        }
    }

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = GDScriptPsiFileRoot(viewProvider)

    override fun createElement(node: ASTNode): PsiElement {
        val rule = node.elementType as RuleIElementType
        return convertRuleToPsi(node, rule)
    }

    private fun convertRuleToPsi(node: ASTNode, rule: RuleIElementType): ANTLRPsiNode {
        return when (rule.ruleIndex) {
            GDScriptLanguageParser.RULE_function -> FunctionSubtree(node, rule)
            GDScriptLanguageParser.RULE_vardef -> VardefSubtree(node, rule)
            GDScriptLanguageParser.RULE_formal_arg -> ArgdefSubtree(node, rule)
            GDScriptLanguageParser.RULE_block -> BlockSubtree(node)
            GDScriptLanguageParser.RULE_call_expr -> CallSubtree(node)
            else -> ANTLRPsiNode(node)
        }
    }

    companion object {

        val FILE = IFileElementType(GDScriptLanguage)
        var ID: TokenIElementType

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(GDScriptLanguage, GDScriptLanguageParser.tokenNames, GDScriptLanguageParser.ruleNames)
            val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(GDScriptLanguage)
            ID = tokenIElementTypes[GDScriptLanguageLexer.ID]
        }

        val COMMENTS = PSIElementTypeFactory.createTokenSet(GDScriptLanguage, GDScriptLanguageLexer.COMMENT, GDScriptLanguageLexer.LINE_COMMENT)
        val WHITESPACE = PSIElementTypeFactory.createTokenSet(GDScriptLanguage, GDScriptLanguageLexer.WS)
        val STRING = PSIElementTypeFactory.createTokenSet(GDScriptLanguage, GDScriptLanguageLexer.STRING)

    }

}
