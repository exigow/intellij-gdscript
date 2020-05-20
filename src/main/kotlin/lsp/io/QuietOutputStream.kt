package lsp.io

import java.io.FilterOutputStream
import java.io.IOException
import java.io.OutputStream

class QuietOutputStream(
    stream: OutputStream,
    private val onException: (IOException) -> Unit
) : FilterOutputStream(stream) {

    override fun write(b: Int) {
        try {
            super.write(b)
        } catch (exception: IOException) {
            super.close()
            onException(exception)
        }
    }

}