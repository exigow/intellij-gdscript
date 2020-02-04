package scene

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree
import scene.ResourceTokenSet.LINE_COMMENTS
import scene.ResourceTokenSet.STRINGS
import scene.ResourceTokenSet.WHITESPACES

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
