package gdscript.commenter.adaptors

import com.intellij.lang.Commenter

open class CommenterAdaptor(
    private val linePrefix: String? = null,
    private val blockPrefix: String? = null,
    private val blockPostfix: String? = null
) : Commenter {

    override fun getLineCommentPrefix() = linePrefix

    override fun getBlockCommentPrefix() = blockPrefix

    override fun getBlockCommentSuffix() = blockPostfix

    override fun getCommentedBlockCommentPrefix(): String? = null

    override fun getCommentedBlockCommentSuffix(): String? = null

}