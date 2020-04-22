package com.delbel.zygote.module

import com.delbel.zygote.module.content.dynamic.SettingsFile
import com.delbel.zygote.module.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.module.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.writer.StringContainerWriter
import com.delbel.zygote.writer.StringContentWriter
import org.hamcrest.CoreMatchers.`is` as isEqualTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class FeatureTest {

    @Test
    fun `create domain should create files`() {
        val stringBuffer = StringBuffer()
        val feature = Feature(name = "> feature", basePackage = "com.delbel.zygote")
        val domain = Module(
            name = "domain",
            feature = feature,
            buildGradle = DomainGradleFile()
        )

        domain.create(
            containerWriter = StringContainerWriter(root = "> ", buffer = stringBuffer),
            contentWriter = StringContentWriter(root = "> ", buffer = stringBuffer)
        )

        assertThat(stringBuffer.toString(), isEqualTo(readFromResource(expected = "/domain")))
    }

    @Test
    fun `create domain and presentation should create files`() {
        val stringBuffer = StringBuffer()
        val feature = Feature(name = "> feature", basePackage = "com.delbel.zygote")
        val domain = Module(
            name = "domain",
            feature = feature,
            buildGradle = DomainGradleFile()
        )
        val presentation = Module(
            name = "presentation",
            feature = feature,
            buildGradle = PresentationGradleFile()
        )

        listOf(domain, presentation).forEach {
            it.create(
                containerWriter = StringContainerWriter(root = "> ", buffer = stringBuffer),
                contentWriter = StringContentWriter(root = "> ", buffer = stringBuffer)
            )
        }

        assertThat(stringBuffer.toString(), isEqualTo(readFromResource(expected = "/domain-presentation")))
    }

    @Test
    fun `create domain and presentation and gateway should create files`() {
        val stringBuffer = StringBuffer()
        val feature = Feature(name = "> feature", basePackage = "com.delbel.zygote")
        val domain = Module(
            name = "domain",
            feature = feature,
            buildGradle = DomainGradleFile()
        )
        val presentation = Module(
            name = "presentation",
            feature = feature,
            buildGradle = PresentationGradleFile()
        )
        val gateway = Module(
            name = "gateway",
            feature = feature,
            buildGradle = PresentationGradleFile()
        )

        listOf(domain, presentation, gateway).forEach {
            it.create(
                containerWriter = StringContainerWriter(root = "> ", buffer = stringBuffer),
                contentWriter = StringContentWriter(root = "> ", buffer = stringBuffer)
            )
        }

        assertThat(stringBuffer.toString(), isEqualTo(readFromResource(expected = "/domain-presentation-gateway")))
    }

    @Test
    fun `create domain and presentation and gateway and editing setings should create files`() {
        val stringBuffer = StringBuffer()
        val feature = Feature(name = "> feature", basePackage = "com.delbel.zygote")
        val domain = Module(
            name = "domain",
            feature = feature,
            buildGradle = DomainGradleFile()
        )
        val presentation = Module(
            name = "presentation",
            feature = feature,
            buildGradle = PresentationGradleFile()
        )
        val gateway = Module(
            name = "gateway",
            feature = feature,
            buildGradle = PresentationGradleFile()
        )
        val settings = SettingsFile()

        listOf(domain, presentation, gateway).forEach {
            it.create(
                containerWriter = StringContainerWriter(root = "> ", buffer = stringBuffer),
                contentWriter = StringContentWriter(root = "> ", buffer = stringBuffer)
            )
            settings.write(writer = StringContentWriter(root = "> ", buffer = stringBuffer), module = it)
        }

        assertThat(stringBuffer.toString(), isEqualTo(readFromResource(expected = "/domain-presentation-gateway-settings")))
    }

    private fun readFromResource(expected: String) = FeatureTest::class.java.getResource(expected).readText()
}