package tscn

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import tscn.parser._TscnLexer
import tscn.psi.TscnElementTypes.*

class TscnSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer =
        FlexAdapter(_TscnLexer(null))

    override fun getTokenHighlights(type: IElementType?): Array<TextAttributesKey> =
        pack(matchColor(type))

    private fun matchColor(type: IElementType?) = when (type) {
        SINGLE_QUOTED_STRING,
        DOUBLE_QUOTED_STRING,
        SINGLE_QUOTED_RESOURCE_STRING,
        DOUBLE_QUOTED_RESOURCE_STRING -> DefaultLanguageHighlighterColors.STRING

        NUMBER -> DefaultLanguageHighlighterColors.NUMBER
        TRUE,
        FALSE,
        NULL,
        NODE_KEYWORD,
        GD_RESOURCE_KEYWORD,
        GD_SCENE_KEYWORD,
        RESOURCE_KEYWORD,
        EXT_RESOURCE,
        SUB_RESOURCE,
        SUB_RESOURCE_KEYWORD,
        EXT_RESOURCE_KEYWORD -> DefaultLanguageHighlighterColors.KEYWORD

        else -> null
    }

}
