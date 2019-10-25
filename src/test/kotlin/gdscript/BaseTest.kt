package gdscript

import com.intellij.testFramework.UsefulTestCase
import com.intellij.testFramework.fixtures.*
import com.intellij.testFramework.fixtures.impl.LightTempDirTestFixtureImpl

abstract class BaseTest : UsefulTestCase() {

    val environment: CodeInsightTestFixture

    init {
        val factory = IdeaTestFixtureFactory.getFixtureFactory()
        val fixtureBuilder = factory.createLightFixtureBuilder(null)
        val tempDirFixture = createTempDirTestFixture()
        environment = IdeaTestFixtureFactory.getFixtureFactory().createCodeInsightFixture(fixtureBuilder.fixture, tempDirFixture)
    }

    override fun setUp() {
        environment.setUp()
    }

    override fun tearDown() {
        environment.tearDown()
    }

    private fun createTempDirTestFixture(): TempDirTestFixture {
        val policy = IdeaTestExecutionPolicy.current()
        return policy?.createTempDirTestFixture()
            ?: LightTempDirTestFixtureImpl(true)
    }

}