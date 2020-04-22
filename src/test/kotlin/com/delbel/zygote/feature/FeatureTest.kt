package com.delbel.zygote.feature

class FeatureTest {

    /*@Test
    fun `create with root name feature should write it down`() {
        val writer = StringWriter(root = "> ")
        val feature = Feature(name = "feature")

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature")))
    }

    @Test
    fun `create with domain module should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = DomainModule(
            parent = "feature",
            packageRoot = "com.delbel.zygote"
        )
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain")))
    }

    @Test
    fun `create with domain module with main source set should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = DomainModule(
            parent = "feature",
            packageRoot = "com.delbel.zygote"
        )
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain_main_source")))
    }

    @Test
    fun `create with domain module with test source set should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = DomainModule(
            parent = "feature",
            packageRoot = "com.delbel.zygote"
        )
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain_test_source")))
    }

    @Test
    fun `create with domain module with sources set should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = DomainModule(
            parent = "feature",
            packageRoot = "com.delbel.zygote"
        )
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain_source")))
    }*/

    private fun readFromResource(expected: String) = FeatureTest::class.java.getResource(expected).readText()
}