package lsp.io

import java.io.FilterInputStream
import java.io.IOException
import java.io.InputStream

class QuietInputStream(
    stream: InputStream,
    private val onException: () -> Unit
) : FilterInputStream(stream) {

    override fun read(): Int {
        return try {
            super.read()
        } catch (ioe: IOException) {
            super.close()
            onException()
            -1
        }
    }

}