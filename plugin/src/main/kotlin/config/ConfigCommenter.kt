package config

import utilities.AbstractCommenter

class ConfigCommenter : AbstractCommenter() {

    override fun getLineCommentPrefix() =
        ";"

}