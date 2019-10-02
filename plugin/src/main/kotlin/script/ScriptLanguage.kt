package script

import com.intellij.lang.Language


object ScriptLanguage: Language("Godot GDScript") {

    override fun isCaseSensitive() = true

}
