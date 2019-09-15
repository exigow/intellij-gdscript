package gdscript.commenter

import com.intellij.lang.Commenter

class ScriptCommenter : Commenter {

    override fun getLineCommentPrefix() = "#"

    override fun getBlockCommentPrefix() = "\"\"\""

    override fun getBlockCommentSuffix() = "\"\"\""

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

}