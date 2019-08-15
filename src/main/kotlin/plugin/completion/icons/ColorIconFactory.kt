package plugin.completion.icons

import java.awt.Color
import java.awt.Component
import java.awt.Graphics
import javax.swing.Icon


object ColorIconFactory {

    fun create(colorCode: Color): Icon = CompletionColorIcon(colorCode, 16, 16)

    private class CompletionColorIcon(val color: Color, val width: Int, val height: Int): Icon {

        override fun paintIcon(c: Component, g: Graphics, x: Int, y: Int) {
            g.color = color
            g.fillRect(x, y, width, height)
        }

        override fun getIconWidth() = width

        override fun getIconHeight() = height

    }

}