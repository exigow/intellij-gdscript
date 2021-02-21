package gdscript

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import gdscript.lexer.ScriptLexerAdapter
import gdscript.parser.ScriptParser
import gdscript.psi.ScriptFile
import gdscript.psi.ScriptTypes

class ScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?) =
        ScriptLexerAdapter()

    override fun createParser(project: Project?) =
        ScriptParser()

    override fun getWhitespaceTokens() =
        TokenSet.create(TokenType.WHITE_SPACE)

    override fun getCommentTokens(): TokenSet =
        TokenSet.create(ScriptTypes.LINE_COMMENT)

    override fun getFileNodeType() =
        IFileElementType(ScriptLanguage)

    override fun getStringLiteralElements(): TokenSet =
        TokenSet.create(ScriptTypes.DOUBLE_QUOTED_STRING)

    override fun createElement(node: ASTNode?): PsiElement =
        ScriptTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider) =
        ScriptFile(viewProvider)

}