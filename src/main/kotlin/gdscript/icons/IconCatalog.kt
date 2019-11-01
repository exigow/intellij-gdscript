package gdscript.icons

import com.intellij.icons.AllIcons.FileTypes
import com.intellij.icons.AllIcons.Nodes
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.LayeredIcon
import javax.swing.Icon

object IconCatalog {

    val GODOT_FILE = IconLoader.getIcon("/fileIcon.png")
    val RESOURCE_FILE: Icon = FileTypes.Config
    val CLASS: Icon = Nodes.Class
    val STATIC_CLASS: Icon = LayeredIcon(Nodes.Class, Nodes.StaticMark)
    val STATIC_METHOD: Icon = LayeredIcon(Nodes.Method, Nodes.StaticMark)
    val STATIC_VARIABLE: Icon = LayeredIcon(Nodes.Variable, Nodes.StaticMark)
    val FUNCTION: Icon = Nodes.Function

}
