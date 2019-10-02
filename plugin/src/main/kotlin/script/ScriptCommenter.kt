package script

import utilities.AbstractCommenter

class ScriptCommenter : AbstractCommenter() {

    override fun getLineCommentPrefix() =
        "#"

    override fun getBlockCommentPrefix() =
        MULTILINE_STRING_MARKER

    override fun getBlockCommentSuffix() =
        MULTILINE_STRING_MARKER

    companion object {

        const val MULTILINE_STRING_MARKER = "\"\"\""
    }

}