package gdscript

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory
import gdscript.highlight.ScriptHighlighter

class ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() =
        ScriptHighlighter()

}
