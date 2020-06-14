package gdscript

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import gdscript.lexer.ScriptLexer
import gdscript.parser.ScriptParser


class ScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer =
        ScriptLexer()

    override fun createParser(project: Project?): PsiParser? =
        ScriptParser()

    override fun getWhitespaceTokens(): TokenSet =
        TokenSet.create(ScriptTokenType.WHITESPACE)

    override fun getCommentTokens() =
        TokenSet.create(ScriptTokenType.LINE_COMMENT)

    override fun getStringLiteralElements() =
        TokenSet.create(ScriptTokenType.DOUBLE_QUOTED_STRING)

    override fun getFileNodeType() =
        FILE_ELEMENT_TYPE

    override fun createFile(view: FileViewProvider): PsiFile =
        ScriptFile(view)

    override fun createElement(node: ASTNode): PsiElement =
        ASTWrapperPsiElement(node)

    private companion object {

        private val FILE_ELEMENT_TYPE = IFileElementType(ScriptLanguage)

    }

}
