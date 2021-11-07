package version

import BaseTest
import version.data.Version


class VersionServiceTest : BaseTest() {

    fun `test v3_2 is default`() {
        assertEquals(VersionService.current().versionId, "3.2")
    }

    fun `test v3_2`() {
        val version = VersionService.all().find { it.versionId == "3.2" }!!
        assertUniqueClasses(version)
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test v3_3`() {
        val version = VersionService.all().find { it.versionId == "3.3" }!!
        assertUniqueClasses(version)
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test v3_4`() {
        val version = VersionService.all().find { it.versionId == "3.4" }!!
        assertUniqueClasses(version)
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test v4_0`() {
        val version = VersionService.all().find { it.versionId == "4.0" }!!
        assertUniqueClasses(version)
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test disabled`() {
        val disabled = VersionService.all().find { it.versionId == "Disabled" }!!
        assertEmpty(disabled.classes)
        assertEmpty(disabled.primitives)
        assertEmpty(disabled.singletons)
        assertEmpty(disabled.globals)
    }

    private fun assertUniqueClasses(version: Version) {
        val all = version.classes + version.globals + version.singletons + version.primitives
        val noDuplicates = all.groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .none()
        assertTrue(noDuplicates)
    }

}