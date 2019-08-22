package plugin

import com.intellij.lang.Commenter

class GDScriptCommenter : Commenter {

    override fun getCommentedBlockCommentPrefix() = ""

    override fun getCommentedBlockCommentSuffix() = ""

    override fun getBlockCommentPrefix() = "\"\"\""

    override fun getBlockCommentSuffix() = "\"\"\""

    override fun getLineCommentPrefix() = "#"

}