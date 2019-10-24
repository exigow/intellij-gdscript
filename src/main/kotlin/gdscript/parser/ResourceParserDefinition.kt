package gdscript.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import gdscript.GDScriptResourceLexer
import gdscript.GDScriptResourceParser
import gdscript.token.ResourceTokenSet.LINE_COMMENTS
import gdscript.token.ResourceTokenSet.STRINGS
import gdscript.token.ResourceTokenSet.WHITESPACES
import gdscript.file.ResourceFile
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree

class ResourceParserDefinition : ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ResourceLanguage, GDScriptResourceParser.tokenNames, GDScriptResourceParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(ResourceLanguage, GDScriptResourceLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(ResourceLanguage, GDScriptResourceParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as GDScriptResourceParser).file()
        }

    override fun getWhitespaceTokens() =
        WHITESPACES

    override fun getCommentTokens() =
        LINE_COMMENTS

    override fun getStringLiteralElements() =
        STRINGS

    override fun getFileNodeType() =
        IFileElementType(ResourceLanguage)

    override fun createFile(viewProvider: FileViewProvider) =
        ResourceFile(viewProvider)

    override fun createElement(node: ASTNode) =
        ANTLRPsiNode(node)

}
