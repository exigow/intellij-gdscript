package gdscript

import com.intellij.testFramework.UsefulTestCase
import com.intellij.testFramework.fixtures.CodeInsightTestFixture
import com.intellij.testFramework.fixtures.IdeaTestExecutionPolicy
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory.getFixtureFactory
import com.intellij.testFramework.fixtures.TempDirTestFixture
import com.intellij.testFramework.fixtures.impl.LightTempDirTestFixtureImpl

abstract class BaseTest : UsefulTestCase() {

    val environment: CodeInsightTestFixture = getFixtureFactory()
        .createCodeInsightFixture(createFixture(), createTempDir())

    override fun setUp() =
        environment.setUp()

    override fun tearDown() =
        environment.tearDown()

    private fun createFixture() = getFixtureFactory()
        .createLightFixtureBuilder()
        .fixture

    private fun createTempDir(): TempDirTestFixture {
        val policy = IdeaTestExecutionPolicy.current()
        return policy?.createTempDirTestFixture()
            ?: LightTempDirTestFixtureImpl(true)
    }

}