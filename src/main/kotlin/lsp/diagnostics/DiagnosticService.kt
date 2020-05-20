package lsp.diagnostics

import com.intellij.openapi.components.Service
import com.intellij.openapi.vfs.VirtualFile
import java.util.*

@Service
class DiagnosticService {

    private val cache: MutableSet<Diagnostic> =
        Collections.synchronizedSet(mutableSetOf())

    fun get(file: VirtualFile): List<Diagnostic> =
        cache.filter { it.file == file }

    fun register(diagnostics: List<Diagnostic>) {
        cache += diagnostics
    }

    fun invalidate(file: VirtualFile) {
        cache.removeIf { it.file == file }
    }

}