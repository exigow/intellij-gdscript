package tscn

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class TscnHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() =
        TscnSyntaxHighlighter()

}
