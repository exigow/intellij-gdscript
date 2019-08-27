package gdscript

import com.intellij.lang.Commenter

object GDScriptCommenter : Commenter {

    private const val BLOCK_COMMENT: String = "\"\"\""

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun getBlockCommentPrefix() = BLOCK_COMMENT

    override fun getBlockCommentSuffix() = BLOCK_COMMENT

    override fun getLineCommentPrefix() = "#"

}