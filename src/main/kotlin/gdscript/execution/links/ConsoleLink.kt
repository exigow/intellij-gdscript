package gdscript.execution.links

data class ConsoleLink(
    val range: IntRange,
    val file: String,
    val line: Int = 0
)