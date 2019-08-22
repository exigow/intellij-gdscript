package plugin.icons

import com.intellij.openapi.util.IconLoader
import java.awt.Color
import java.awt.Component
import java.awt.Graphics
import javax.swing.Icon

object GDScriptIconFactory {

    fun createLogo() = IconLoader.getIcon("META-INF/pluginIcon.svg")

    fun createColor(color: Color) = object : Icon {

        override fun paintIcon(component: Component, graphics: Graphics, x: Int, y: Int) {
            graphics.color = color
            graphics.fillRect(x, y, iconWidth, iconHeight)
        }

        override fun getIconWidth() = 16

        override fun getIconHeight() = 16

    }

}