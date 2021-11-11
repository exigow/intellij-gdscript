package gdscript

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
import gdscript.lexer.ScriptIndentLexer
import gdscript.lexer.ScriptLexerAdapter
import gdscript.parser.ScriptParser
import gdscript.psi.ScriptElementTypes.*


class ScriptParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer =
        ScriptIndentLexer()

    override fun createParser(project: Project?): PsiParser =
        ScriptParser()

    override fun getCommentTokens() =
        TokenSet.create(LINE_COMMENT)

    override fun getStringLiteralElements() =
        TokenSet.create(
            DOUBLE_QUOTED_STRING,
            SINGLE_QUOTED_STRING,
            MULTILINE_DOUBLE_QUOTED_STRING,
            MULTILINE_SINGLE_QUOTED_STRING
        )

    override fun getFileNodeType() =
        FILE_ELEMENT_TYPE

    override fun createFile(view: FileViewProvider): PsiFile =
        ScriptFile(view)

    override fun createElement(node: ASTNode): PsiElement =
        Factory.createElement(node)

    private companion object {

        private val FILE_ELEMENT_TYPE = IFileElementType(ScriptLanguage)

    }

}
