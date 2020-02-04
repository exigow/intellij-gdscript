package gdscript

import com.intellij.lang.Commenter

class ScriptCommenter : Commenter {

    override fun getLineCommentPrefix() = "#"

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun getBlockCommentPrefix() = MULTILINE_STRING_MARKER

    override fun getBlockCommentSuffix() = MULTILINE_STRING_MARKER

    companion object {
        const val MULTILINE_STRING_MARKER = "\"\"\""
    }

}