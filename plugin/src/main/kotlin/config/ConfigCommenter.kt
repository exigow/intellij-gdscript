package config

import utilities.NullCommenter

class ConfigCommenter : NullCommenter() {

    override fun getLineCommentPrefix() = ";"

}