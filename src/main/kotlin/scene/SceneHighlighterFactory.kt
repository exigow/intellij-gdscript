package scene

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory

class SceneHighlighterFactory : SingleLazyInstanceSyntaxHighlighterFactory() {

    override fun createHighlighter() = SceneHighlighter()

}
