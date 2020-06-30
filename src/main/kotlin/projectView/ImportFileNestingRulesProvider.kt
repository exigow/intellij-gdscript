package projectView

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider

object ImportFileNestingRulesProvider : ProjectViewNestingRulesProvider {
    private val EXTENSIONS: Array<String> = arrayOf(".png", ".wav")

    override fun addFileNestingRules(consumer: ProjectViewNestingRulesProvider.Consumer) {
        for (extension in EXTENSIONS) {
            consumer.addNestingRule(extension, "$extension.import")
        }
    }
}
