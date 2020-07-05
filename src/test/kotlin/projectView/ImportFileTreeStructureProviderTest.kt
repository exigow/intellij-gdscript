package projectView

import com.intellij.ide.projectView.ProjectView
import com.intellij.projectView.TestProjectTreeStructure
import com.intellij.testFramework.PlatformTestUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import utils.addFile

class ImportFileTreeStructureProviderTest : BasePlatformTestCase() {

    fun `test import files are nested by default`() {
        val projectView = ProjectView.getInstance(project)
        val pane = configurePane(useNesting = true)
        projectView.addProjectPane(pane)

        myFixture.addFile("my_texture.png")
        myFixture.addFile("my_texture.png.import")

        PlatformTestUtil.expandAll(pane.tree)

        val expected = """
            -Project
             -PsiDirectory: src
              -my_texture.png
               my_texture.png.import
             External Libraries
        """.trimIndent()
        PlatformTestUtil.assertTreeEqual(pane.tree, expected)
    }

    fun `test import files are not nested if configured`() {
        val projectView = ProjectView.getInstance(project)
        val pane = configurePane(useNesting = false)
        projectView.addProjectPane(pane)

        myFixture.addFile("my_texture.png")
        myFixture.addFile("my_texture.png.import")

        PlatformTestUtil.expandAll(pane.tree)

        val expected = """
            -Project
             -PsiDirectory: src
              my_texture.png
              my_texture.png.import
             External Libraries
        """.trimIndent()
        PlatformTestUtil.assertTreeEqual(pane.tree, expected)
    }

    private fun configurePane(useNesting: Boolean) =
        object : TestProjectTreeStructure(project, testRootDisposable) {

            override fun isUseFileNestingRules() = useNesting

        }.createPane()

}