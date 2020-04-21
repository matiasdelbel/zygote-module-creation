package com.delbel.zygote.feature

import com.delbel.zygote.writer.StringWriter
import org.hamcrest.CoreMatchers.`is` as isEqualTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FeatureTest {

    @Test
    fun `create with root name feature should write it down`() {
        val writer = StringWriter(root = "> ")
        val feature = Feature.Builder()
            .root(name = "feature")
            .build()

        val result = feature.create(writer)

        val expected = "> feature/"

        assertThat(result, isEqualTo(expected))
    }
}