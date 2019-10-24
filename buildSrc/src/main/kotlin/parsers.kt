import org.jsoup.nodes.Document


fun isLanguageClass(file: Document) = file
    .select("class")
    .attr("name").startsWith("@")

fun isNotEmptyClass(file: Document) = file
    .select("class")
    .attr("name").isNotEmpty()

fun isPrimitiveClass(file: Document) = file
    .select("class")
    .attr("name") in listOf("bool", "float", "void", "int")

fun collectConstants(file: Document) = file
    .select("constant")
    .map { Constant(it.attr("name"), it.attr("value")) }

fun collectLinks(listPage: Document) =
    listPage.select(".files a[title$=.xml]")
        .map { it.absUrl("href") }
        .map { it.replace("blob", "raw") }

fun parseClass(file: Document) = Class(
    name = file.select("class").attr("name"),
    extends = file.select("class").attr("inherits"),
    description = file.select("brief_description").text().trimIndent().trim(),
    fields = parseFields(file),
    methods = parseMethods(file),
    constants = collectConstants(file)
)

fun parseMethods(file: Document) = file
    .select("method")
    .map {
        Method(
            name = it.attr("name"),
            type = it.select("return").attr("type"),
            arguments = it.select("argument")
                .sortedBy { argument -> argument.attr("index") }
                .map { argument ->
                    Argument(
                        name = argument.attr("name"),
                        type = argument.attr("type")
                    )
                }
        )
    }


fun parseFields(file: Document) = file
    .select("member")
    .map { field ->
        Field(
            name = field.attr("name"),
            type = field.attr("type"),
            setter = field.attr("setter"),
            getter = field.attr("getter"),
            default = field.attr("default")
        )
    }
