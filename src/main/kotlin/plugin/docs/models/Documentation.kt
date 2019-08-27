package plugin.docs.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Documentation(
    val name: String,
    val inherits: String?, // todo: rename to extends (override name with jsonprop)
    val members: List<Member>?,
    val methods: List<Method>?,
    val constants: List<Constant>?,
    @JsonProperty("brief_description") val briefDescription: String?
) {

    fun usefulMembersNames() = useful(members) { m -> m.name }

    fun usefulMethodsNames() = useful(methods) { m -> m.name }

    fun usefulConstantsNames() = useful(constants) { m -> m.name }

    private fun <T> useful(completions: List<T>?, conversion: (T) -> String): List<String> = completions
        ?.map { conversion(it) }
        ?.filter { it.isNotEmpty() }
        ?.distinct() ?: emptyList()

}