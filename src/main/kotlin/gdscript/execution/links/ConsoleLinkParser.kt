package gdscript.execution.links

object ConsoleLinkParser {

    private val RESOURCE_REGEX = "(res://[a-zA-Z0-9/.\\-]+(:[0-9]+)?)"
        .toRegex()

    fun parseText(line: String): Set<ConsoleLink> =
        RESOURCE_REGEX.findAll(line)
            .map { it.groups[1]!! }
            .map { it.range }
            .map { parseLink(it, line.substring(it)) }
            .toSet()

    private fun parseLink(range: IntRange, link: String): ConsoleLink {
        val path = cleanLink(link)
        return if (path.contains(":")) {
            val coords = path.split(":")
            ConsoleLink(range, coords[0], coords[1].toInt())
        } else
            ConsoleLink(range, path)
    }

    private fun cleanLink(fragment: String) = fragment
        .removePrefix("res://")
        .removeSuffix(".")



}
