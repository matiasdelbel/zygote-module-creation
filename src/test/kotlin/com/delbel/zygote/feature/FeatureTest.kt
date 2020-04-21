package com.delbel.zygote.feature

import com.delbel.zygote.writer.StringWriter
import org.hamcrest.CoreMatchers.`is` as isEqualTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FeatureTest {

    @Test
    fun `create with root name feature should write it down`() {
        val writer = StringWriter(root = "> ")
        val feature = Feature.Builder(name = "feature")
            .build()

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature")))
    }

    @Test
    fun `create with domain module should write it down`() {
        val writer = StringWriter(root = "> ")
        val domainModule = Module.Builder(name = "domain")
        val feature = Feature.Builder(name = "feature")
            .module(domainModule)
            .build()

        feature.create(writer)

        assertThat(writer.test(), isEqualTo(readFromResource(expected = "/feature_domain")))
    }

    private fun readFromResource(expected: String) = FeatureTest::class.java.getResource(expected).readText()
}