package gdscript.commenter

import com.intellij.lang.Commenter

abstract class NullCommenter : Commenter {

    override fun getLineCommentPrefix(): String? = null

    override fun getBlockCommentPrefix(): String? = null

    override fun getBlockCommentSuffix(): String? = null

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

}