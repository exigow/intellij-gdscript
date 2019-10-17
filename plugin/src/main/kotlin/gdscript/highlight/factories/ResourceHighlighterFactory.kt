package gdscript.highlight.factories

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import gdscript.highlight.ResourceHighlighter

class ResourceHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = ResourceHighlighter()

}
