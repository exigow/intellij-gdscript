package gdscript.completion.sources

import com.google.gson.Gson

object CompletionDeserializer {

    fun deserialize(): Language {
        val path = "completion.json"
        val stream = this::class.java.classLoader.getResourceAsStream(path)!!
        return Gson().fromJson<Language>(stream.reader(), Language::class.java)
    }

}