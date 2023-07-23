package tscn

import com.intellij.lang.Commenter

class TscnCommenter : Commenter {

    override fun getLineCommentPrefix() =
        ";"

    override fun getCommentedBlockCommentPrefix(): String? =
        null

    override fun getCommentedBlockCommentSuffix(): String? =
        null

    override fun getBlockCommentPrefix(): String? =
        null

    override fun getBlockCommentSuffix(): String? =
        null

}
