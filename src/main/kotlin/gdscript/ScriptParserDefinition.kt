package gdscript

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import gdscript.ScriptTokenSet.LINE_COMMENTS
import gdscript.ScriptTokenSet.STRINGS
import gdscript.ScriptTokenSet.WHITESPACES
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree


class ScriptParserDefinition : com.intellij.lang.ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, ScriptParser.tokenNames, ScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(ScriptLanguage, ScriptLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(ScriptLanguage, ScriptParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as ScriptParser).file()
        }

    override fun getWhitespaceTokens(): TokenSet =
        WHITESPACES

    override fun getCommentTokens(): TokenSet =
        LINE_COMMENTS

    override fun getStringLiteralElements(): TokenSet =
        STRINGS

    override fun getFileNodeType() =
        FILE

    override fun createFile(view: FileViewProvider) =
        ScriptFile(view)

    override fun createElement(node: ASTNode) =
        ANTLRPsiNode(node)

    companion object {

        val FILE = IFileElementType(ScriptLanguage)

    }

}
