package gdscript.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import gdscript.completion.utils.LookupFactory.createKeyword
import gdscript.completion.utils.LookupFactory.createKeywordWithSpace
import gdscript.psi.ScriptElementTypes.LINE_BREAK


class KeywordCompletionContributor : CompletionContributor() {

    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val keywords = getKeywords(parameters.position)
        result.addAllElements(keywords)
    }

    private fun getKeywords(element: PsiElement): Set<LookupElement> {
        val prev = PsiTreeUtil.prevLeaf(element)
            ?: return emptySet()
        if (prev.elementType == LINE_BREAK)
            return STARTER_KEYWORDS
        if (prev.elementType == WHITE_SPACE && PsiTreeUtil.prevLeaf(prev).elementType == LINE_BREAK)
            return STARTER_KEYWORDS
        val prevVisibleText = PsiTreeUtil.prevVisibleLeaf(element)?.text
        return CONTINUATION_KEYWORDS[prevVisibleText].orEmpty()
    }

    private companion object {

        private val CONTINUATION_KEYWORDS = mapOf(
            "export" to setOf(createKeywordWithSpace("var")),
            "onready" to setOf(createKeywordWithSpace("var")),
            "master" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "mastersync" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "puppet" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "puppetsync" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "remote" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "remotesync" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "sync" to setOf(createKeywordWithSpace("var"), createKeywordWithSpace("func")),
            "static" to setOf(createKeywordWithSpace("func"))
        )

        private val STARTER_KEYWORDS = setOf(
            createKeywordWithSpace("var"),
            createKeywordWithSpace("const"),
            createKeywordWithSpace("func"),
            createKeywordWithSpace("class_name"),
            createKeywordWithSpace("class"),
            createKeywordWithSpace("static func"),
            createKeywordWithSpace("export var"),
            createKeywordWithSpace("onready var"),
            createKeywordWithSpace("signal"),
            createKeywordWithSpace("return"),
            createKeywordWithSpace("extends"),
            createKeywordWithSpace("enum"),
            createKeywordWithSpace("if"),
            createKeywordWithSpace("elif"),
            createKeywordWithSpace("else"),
            createKeywordWithSpace("for"),
            createKeywordWithSpace("while"),
            createKeywordWithSpace("match"),
            createKeyword("break"),
            createKeyword("continue"),
            createKeyword("pass")
        )

    }

}