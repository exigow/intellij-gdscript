package tscn

import com.intellij.ide.highlighter.custom.CustomFileHighlighter
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class TscnHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() =
        CustomFileHighlighter(TscnSyntaxTable())

}
