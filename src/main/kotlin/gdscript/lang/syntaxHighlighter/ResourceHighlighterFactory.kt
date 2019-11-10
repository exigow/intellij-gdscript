package gdscript.lang.syntaxHighlighter

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class ResourceHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = ResourceHighlighter()

}
