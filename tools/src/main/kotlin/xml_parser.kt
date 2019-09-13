import org.jsoup.nodes.Element


fun parse(xml: Element) = Library.Class(
    name = xml.select("class").attr("name"),
    extends = xml.select("class").attr("inherits"),
    description = xml.select("brief_description").text().trimIndent().trim(),
    fields = xml.select("member").map { parseField(it) },
    methods = xml.select("method").map { parseMethod(it) },
    constants = xml.select("constant").map { parseConstant(it) }
)

private fun parseMethod(method: Element) =
    Library.Class.Method(
        name = method.attr("name"),
        type = method.select("return").attr("type"),
        arguments = method.select("argument")
            .sortedBy { it.attr("index") }
            .map { argument ->
                Library.Class.Method.Argument(
                    name = argument.attr("name"),
                    type = argument.attr("type")
                )
            }
    )

private fun parseConstant(constant: Element) =
    Library.Class.Constant(
        name = constant.attr("name"),
        value = constant.attr("value")
    )

private fun parseField(field: Element) =
    Library.Class.Field(
        name = field.attr("name"),
        type = field.attr("type"),
        setter = field.attr("setter"),
        getter = field.attr("getter"),
        default = field.attr("default")
    )
