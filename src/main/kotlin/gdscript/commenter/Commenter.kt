package gdscript.commenter

class Commenter : com.intellij.lang.Commenter {

    private val blockComment: String = "\"\"\""

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

    override fun getBlockCommentPrefix() = blockComment

    override fun getBlockCommentSuffix() = blockComment

    override fun getLineCommentPrefix() = "#"

}