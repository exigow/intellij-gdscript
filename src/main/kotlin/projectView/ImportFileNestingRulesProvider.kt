package projectView

import com.intellij.ide.projectView.ProjectViewNestingRulesProvider

/**
 * Add default nesting rules for Godot projects.
 *
 * This nests .import metadata files beneath the imported asset in the
 * ProjectView tree structure. Users are able to disable this if they want and
 * the IDE will remember their choices per rule.
 */
object ImportFileNestingRulesProvider : ProjectViewNestingRulesProvider {
    private val EXTENSIONS: Array<String> = arrayOf(".png", ".wav")

    override fun addFileNestingRules(consumer: ProjectViewNestingRulesProvider.Consumer) {
        for (extension in EXTENSIONS) {
            consumer.addNestingRule(extension, "$extension.import")
        }
    }
}
