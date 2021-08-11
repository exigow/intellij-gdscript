package version

import BaseTest


class VersionServiceTest : BaseTest() {

    fun `test disabled`() {
        val disabled = VersionService.all().find { it.version == "Disabled" }!!
        assertEmpty(disabled.classes)
        assertEmpty(disabled.primitives)
        assertEmpty(disabled.singletons)
        assertEmpty(disabled.globals)
    }

    fun `test v3`() {
        val version = VersionService.all().find { it.version == "3.2.2" }!!
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test v4`() {
        val version = VersionService.all().find { it.version == "4.0" }!!
        assertNotEmpty(version.classes)
        assertNotEmpty(version.primitives)
        assertNotEmpty(version.singletons)
        assertNotEmpty(version.globals)
    }

    fun `test v3 is default`() {
        val current = VersionService.current()
        assertEquals(current.version, "3.2.2")
    }

    fun `test v3 has no duplicated classes`() {
        val version = VersionService.all().find { it.version == "3.2.2" }!!
        val all = version.classes + version.globals + version.singletons + version.primitives
        val noDuplicates = all.groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .none()
        assertTrue(noDuplicates)
    }

}