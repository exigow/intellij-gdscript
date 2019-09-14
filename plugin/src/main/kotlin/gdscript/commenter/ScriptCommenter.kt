package gdscript.commenter

class ScriptCommenter : com.intellij.lang.Commenter {

    override fun getLineCommentPrefix() = "#"

    override fun getBlockCommentPrefix() = "\"\"\""

    override fun getBlockCommentSuffix() = "\"\"\""

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

}