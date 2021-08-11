package tscn

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import tscn.parser.TscnParser
import tscn.parser._TscnLexer
import tscn.psi.TscnElementTypes
import tscn.psi.TscnFile

class TscnParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer =
        FlexAdapter(_TscnLexer(null))

    override fun createParser(project: Project?): PsiParser =
        TscnParser()

    override fun getCommentTokens(): TokenSet =
        TokenSet.create(TscnElementTypes.COMMENT)

    override fun getStringLiteralElements(): TokenSet =
        TokenSet.create(TscnElementTypes.SINGLE_QUOTED_STRING, TscnElementTypes.DOUBLE_QUOTED_STRING)

    override fun getFileNodeType() =
        FILE_ELEMENT_TYPE

    override fun createFile(view: FileViewProvider): PsiFile =
        TscnFile(view)

    override fun createElement(node: ASTNode): PsiElement =
        TscnElementTypes.Factory.createElement(node)

    companion object {

        private val FILE_ELEMENT_TYPE = IFileElementType(TscnLanguage)

    }

}
