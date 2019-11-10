package gdscript.lang.syntaxHighlighter

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class ScriptHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = ScriptHighlighter()


}
