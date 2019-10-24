package gdscript.completion.sources

import com.google.gson.Gson

val COMPLETION_DATA = Deserializer.deserialize()

object Deserializer {
    fun deserialize(): Language {
        val inputStream = this::class.java.classLoader.getResourceAsStream("api.json")!!.reader()
        return Gson().fromJson<Language>(inputStream, Language::class.java)
    }
}