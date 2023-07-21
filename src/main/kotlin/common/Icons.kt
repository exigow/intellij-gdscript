package common

import com.intellij.icons.AllIcons.FileTypes
import com.intellij.icons.AllIcons.Nodes
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.LayeredIcon
import javax.swing.Icon

object Icons {

    @JvmField
    val GDSCRIPT_FILE = IconLoader.getIcon("/fileIcon.png", javaClass)
    val TSCN_FILE: Icon = FileTypes.Config
    val JSON_FILE: Icon = FileTypes.Json
    val ANY_FILE: Icon = FileTypes.Any_type
    val CLASS: Icon = Nodes.Class
    val STATIC_CLASS: Icon = LayeredIcon(Nodes.Class, Nodes.StaticMark)
    val STATIC_METHOD: Icon = LayeredIcon(Nodes.Method, Nodes.StaticMark)
    val STATIC_VARIABLE: Icon = LayeredIcon(Nodes.Variable, Nodes.StaticMark)
    val FUNCTION: Icon = Nodes.Function
    val RUN: Icon = LayeredIcon(GDSCRIPT_FILE, Nodes.RunnableMark)

}
