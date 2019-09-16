package gdscript

import gdscript.utilities.AbstractCommenter

class ConfigCommenter : AbstractCommenter() {

    override fun getLineCommentPrefix() =
        ";"

}