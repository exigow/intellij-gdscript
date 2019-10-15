package gdscript.lang

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import gdscript.GDScriptLexer
import gdscript.GDScriptParser
import gdscript.lang.ScriptTokenSet.LINE_COMMENT
import gdscript.lang.ScriptTokenSet.STRING
import gdscript.lang.ScriptTokenSet.WHITESPACE
import gdscript.lang.psi.file.ScriptPsiFile
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.tree.ParseTree


class ScriptParserDefinition : com.intellij.lang.ParserDefinition {

    init {
        @Suppress("DEPRECATION")
        PSIElementTypeFactory.defineLanguageIElementTypes(ScriptLanguage, GDScriptParser.tokenNames, GDScriptParser.ruleNames)
    }

    override fun createLexer(project: Project): Lexer =
        ANTLRLexerAdaptor(ScriptLanguage, GDScriptLexer(null))

    override fun createParser(project: Project): PsiParser =
        object : ANTLRParserAdaptor(ScriptLanguage, GDScriptParser(null)) {
            override fun parse(parser: Parser, root: IElementType): ParseTree =
                (parser as GDScriptParser).file()
        }

    override fun getWhitespaceTokens(): TokenSet = WHITESPACE

    override fun getCommentTokens(): TokenSet = LINE_COMMENT

    override fun getStringLiteralElements(): TokenSet = STRING

    override fun getFileNodeType() = IFileElementType(ScriptLanguage)

    override fun createFile(view: FileViewProvider) = ScriptPsiFile(view)

    override fun createElement(node: ASTNode) = ScriptPsiFactory.createPsiElement(node)

}
