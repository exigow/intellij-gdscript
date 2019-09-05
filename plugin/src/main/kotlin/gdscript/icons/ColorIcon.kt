package gdscript.icons

import java.awt.Color
import java.awt.Component
import java.awt.Graphics
import javax.swing.Icon

class ColorIcon(private val color: Color) : Icon {

    override fun paintIcon(component: Component, graphics: Graphics, x: Int, y: Int) {
        graphics.color = color
        graphics.fillRect(x, y, iconWidth, iconHeight)
    }

    override fun getIconWidth() = 16

    override fun getIconHeight() = 16

}
