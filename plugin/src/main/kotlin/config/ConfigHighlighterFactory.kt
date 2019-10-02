package config

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class ConfigHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = ConfigHighlighter()

}
