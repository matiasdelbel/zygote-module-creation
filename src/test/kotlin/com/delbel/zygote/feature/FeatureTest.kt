package com.delbel.zygote.feature

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.writer.StringWriter
import org.hamcrest.CoreMatchers.`is` as isEqualTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FeatureTest {

    @Test
    fun `create with root name feature should write it down`() {
        val writer = StringWriter(root = "> ")
        val feature = Feature(name = "feature")

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature")))
    }

    @Test
    fun `create with domain module should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = Module(parent = "feature", name = "domain")
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain")))
    }

    @Test
    fun `create with domain module with top files should write it down`() {
        val writer = StringWriter(root = "> ")
        val domain = Module(
            parent = "feature",
            name = "domain",
            proGuard = ProGuard,
            gitIgnore = GitIgnore
        )
        val feature = Feature(name = "feature", modules = listOf(domain))

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain_top_files")))
    }

    private fun readFromResource(expected: String) = FeatureTest::class.java.getResource(expected).readText()
}