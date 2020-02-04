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
import scene.SceneTokenSet.LINE_COMMENTS
import scene.SceneTokenSet.STRINGS
import scene.SceneTokenSet.WHITESPACES

class SceneParserDefinition : ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(SceneLanguage, SceneParser.tokenNames, SceneParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(SceneLanguage, SceneLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(SceneLanguage, SceneParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as SceneParser).file()
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
        SceneFile(viewProvider)

    override fun createElement(node: ASTNode) =
        ANTLRPsiNode(node)

    companion object {

        val FILE = IFileElementType(SceneLanguage)

    }

}
