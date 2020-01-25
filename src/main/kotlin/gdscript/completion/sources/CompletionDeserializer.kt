package gdscript.completion.sources

import com.google.gson.Gson

object CompletionDeserializer {

    fun deserialize(): Array<Class> {
        val path = "completion.json"
        val stream = this::class.java.classLoader.getResourceAsStream(path)!!
        return Gson().fromJson<Array<Class>>(stream.reader(), Array<Class>::class.java)
    }

}