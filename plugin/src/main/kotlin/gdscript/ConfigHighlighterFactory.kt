package gdscript

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import gdscript.highlight.ConfigHighlighter

class ConfigHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() =
        ConfigHighlighter()

}
