package version

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import version.data.*

fun parseClass(doc: Document) = Class(
    name = doc.select("class").attr("name"),
    briefDescription = doc.select("class > brief_description").text(),
    extends = doc.select("class").attr("inherits"),
    fields = doc.select("member").map { parseField(it) },
    methods = doc.select("method,constructor").map { parseMethod(it) },
    constants = doc.select("constant").map { parseConstant(it) },
    signals = doc.select("signal").map { parseSignal(it) }
)

private fun parseField(field: Element) = Field(
    name = field.attr("name"),
    type = field.attr("type"),
    setter = field.attr("setter"),
    getter = field.attr("getter"),
    default = field.attr("default").ifBlank { null }
)

private fun parseMethod(method: Element) = Method(
    name = method.attr("name"),
    type = method.select("return").attr("type"),
    arguments = parseArguments(method),
    vararg = method.attr("qualifiers") == "vararg"
)

private fun parseConstant(constant: Element) = Constant(
    name = constant.attr("name"),
    value = constant.attr("value")
)

private fun parseSignal(signal: Element) = Signal(
    name = signal.attr("name"),
    arguments = parseArguments(signal)
)

private fun parseArguments(method: Element) = method
    .select("argument,param")
    .sortedBy { it.attr("index") }
    .map { Argument(it.attr("name"), it.attr("type")) }
