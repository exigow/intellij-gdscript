package gdscript.execution.filters

object LinkParser {

    private val RESOURCE_REGEX = "(res://[a-zA-Z0-9/.\\-]+(:[0-9]+)?)".toRegex()

    fun parseAll(line: String): List<Link> {
        val ranges = findMatchingRanges(line)
        return ranges
            .map { range ->
                Link(
                    range,
                    parsePath(line.substring(range)),
                    parseLine(line.substring(range))
                )
            }
    }

    private fun findMatchingRanges(line: String): List<IntRange> {
        return RESOURCE_REGEX.findAll(line)
            .map { it.groups[1]!! }
            .map { it.range }
            .toList()
    }

    private fun parsePath(resource: String): String {
        val noPrefix = resource.removePrefix("res://")
        if (noPrefix.contains(":"))
            return noPrefix.substringBeforeLast(":")
        return noPrefix.removeSuffix(".")
    }

    private fun parseLine(resource: String): Int {
        val noPrefix = resource.removePrefix("res://")
        if (noPrefix.contains(":"))
            return resource.substringAfterLast(":").toInt()
        return 0
    }

    data class Link(
        val range: IntRange,
        val file: String,
        val line: Int = 0
    )

}
