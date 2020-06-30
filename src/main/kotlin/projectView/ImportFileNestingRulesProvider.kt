package projectView

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider
import com.intellij.psi.search.FilenameIndex

object ImportFileNestingRulesProvider : ProjectViewNestingRulesProvider {
    override fun addFileNestingRules(consumer: ProjectViewNestingRulesProvider.Consumer) {
        val extensions = HashSet<String>()

        for (filename in FilenameIndex.getAllFilenames(null)) {
            if (filename.endsWith(".import")) {
                val originalFilename = filename.removeSuffix(".import")

                if (originalFilename.contains(".")) {
                    val extension = originalFilename.split(".").last()
                    extensions.add(extension)
                }
            }
        }

        for (extension in extensions) {
            consumer.addNestingRule(".$extension", ".$extension.import")
        }
    }
}
