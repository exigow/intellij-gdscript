package gdscript

import com.intellij.lang.Commenter

class ScriptCommenter : Commenter {

    override fun getLineCommentPrefix() =
        "#"

    override fun getCommentedBlockCommentPrefix(): String? =
        null

    override fun getCommentedBlockCommentSuffix(): String? =
        null

    override fun getBlockCommentPrefix(): String? =
        null

    override fun getBlockCommentSuffix(): String? =
        null

}