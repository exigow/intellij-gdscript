package tasks

import okhttp3.*
import okio.IOException
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.net.URLDecoder
import java.util.concurrent.CountDownLatch

open class DownloadDocumentation : DefaultTask() {

    private val client = OkHttpClient()
    private val downloadsDirectory = "${project.buildDir}/downloads"

    @TaskAction
    fun run() {
        val classesUrls = collectClassesUrls().sorted()
        File(downloadsDirectory).mkdirs()
        val latch = CountDownLatch(classesUrls.size)
        for (url in classesUrls) {
            val onSuccessCallback = consumeAsyncOnSuccess(latch, ::processResponse)
            client.newCall(buildGet(url))
                .enqueue(onSuccessCallback)
        }
        latch.await()
    }

    private fun processResponse(call: Call, response: Response) {
        println("Saving ${call.request().url}")
        val name = call.request().url.pathSegments.last()
        val file = File("$downloadsDirectory/$name")
        val isNew = file.createNewFile()
        if (isNew) {
            val data = response.body!!.bytes()
            file.writeBytes(data)
        }
        response.body!!.close()
    }

    private fun consumeAsyncOnSuccess(latch: CountDownLatch, onSuccess: (call: Call, response: Response) -> Unit) = object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()
            latch.countDown()
        }

        override fun onResponse(call: Call, response: Response) {
            onSuccess(call, response)
            latch.countDown()
        }
    }

    private fun collectClassesUrls(): List<String> {
        val catalog = downloadClassesCatalog()
        val classesUrls = catalog.select(".files .content a[title$=.xml]")
            .map { it.attr("href") }
            .map { query -> "https://github.com$query" }
            .map { it.replace("blob", "raw") }
            .map { URLDecoder.decode(it, "UTF-8"); }
        val languageUrl = "https://github.com/godotengine/godot/raw/master/modules/gdscript/doc_classes/@GDScript.xml"
        return classesUrls + languageUrl
    }

    private fun downloadClassesCatalog(): Document {
        val request = buildGet("https://github.com/godotengine/godot/tree/master/doc/classes")
        val response = client.newCall(request).execute()
        return Jsoup.parse(response.body!!.string())
    }

    private fun buildGet(url: String) =
        Request.Builder().get().url(url).build()

}
