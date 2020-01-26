package gdscript.lang.parserDefinition

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import gdscript.ResourceLexer
import gdscript.ResourceParser
import gdscript.lang.ResourceLanguage
import gdscript.lang.ResourceTokenSet.LINE_COMMENTS
import gdscript.lang.ResourceTokenSet.STRINGS
import gdscript.lang.ResourceTokenSet.WHITESPACES
import gdscript.lang.psi.ResourceFile
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ResourceParserDefinition : ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ResourceLanguage, ResourceParser.tokenNames, ResourceParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(ResourceLanguage, ResourceLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(ResourceLanguage, ResourceParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as ResourceParser).file()
        }

    override fun getWhitespaceTokens() =
        WHITESPACES

    override fun getCommentTokens() =
        LINE_COMMENTS

    override fun getStringLiteralElements() =
        STRINGS

    override fun getFileNodeType() =
        FILE

    override fun createFile(viewProvider: FileViewProvider) =
        ResourceFile(viewProvider)

    override fun createElement(node: ASTNode) =
        ANTLRPsiNode(node)

    companion object {

        val FILE = IFileElementType(ResourceLanguage)

    }

}
