package api

import BaseTest


class VersionedClassesServiceTest : BaseTest() {

    fun `test "disabled" option is available with empty classes`() {
        val service = VersionedClassesService()
        val disabled = service.versions.find { it.name == "Disabled" }!!
        assertEmpty(disabled.classes)
        assertEmpty(disabled.primitives)
        assertEmpty(disabled.singletons)
        assertEmpty(disabled.globals)
    }

    fun `test v3 is available`() {
        val service = VersionedClassesService()
        val api = service.versions.find { it.name == DEFAULT_NAME }!!
        assertNotEmpty(api.classes)
        assertNotEmpty(api.primitives)
        assertNotEmpty(api.singletons)
        assertNotEmpty(api.globals)
    }

    fun `test v4 is available`() {
        val service = VersionedClassesService()
        val api = service.versions.find { it.name == "4.0" }!!
        assertNotEmpty(api.classes)
        assertNotEmpty(api.primitives)
        assertNotEmpty(api.singletons)
        assertNotEmpty(api.globals)
    }

    fun `test v3 is default option`() {
        val service = VersionedClassesService()
        val current = service.current()
        assertEquals(current.name, DEFAULT_NAME)
    }

    fun `test union of all v3 classes has no duplicated because classes must be unique`() {
        val api = VersionedClassesService().versions.find { it.name == DEFAULT_NAME }!!
        val all = api.classes + api.globals + api.singletons + api.primitives
        val duplicates = all.groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
        assertEmpty(duplicates.toList())
    }

    private companion object {

        const val DEFAULT_NAME = "3.2.2"

    }

}