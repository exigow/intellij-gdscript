package gdscript.highlight

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class GdSyntaxHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = GdSyntaxHighlighter()

}
