package tscn

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.ide.highlighter.custom.CustomFileTypeLexer
import com.intellij.lang.ASTFactory
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.CustomHighlighterTokenType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiUtilCore

class TscnParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer =
        CustomFileTypeLexer(TscnSyntaxTable.configured())

    override fun createParser(project: Project?): PsiParser? =
        null

    override fun getCommentTokens() =
        TokenSet.create(CustomHighlighterTokenType.LINE_COMMENT)

    override fun getStringLiteralElements() =
        TokenSet.create(CustomHighlighterTokenType.STRING)

    override fun getFileNodeType() =
        FILE_ELEMENT_TYPE

    override fun createFile(view: FileViewProvider): PsiFile =
        object : PsiFileBase(view, TscnLanguage) {

            override fun getFileType() = TscnFileType

        }

    override fun createElement(node: ASTNode): PsiElement =
        PsiUtilCore.NULL_PSI_ELEMENT

    private companion object {

        private val ELEMENT_TYPE = IElementType("TSCN_TEXT", TscnLanguage)
        private val FILE_ELEMENT_TYPE = object : IFileElementType(TscnLanguage) {

            override fun parseContents(chameleon: ASTNode): ASTNode =
                ASTFactory.leaf(ELEMENT_TYPE, chameleon.chars)

        }

    }

}
