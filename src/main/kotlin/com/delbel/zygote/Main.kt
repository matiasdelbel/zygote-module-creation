package com.delbel.zygote

import com.delbel.zygote.feature.*
import com.delbel.zygote.feature.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.GatewayGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.feature.Module
import com.delbel.zygote.writer.DirectoryContainerWriter
import com.delbel.zygote.writer.FileContentWriter
import com.delbel.zygote.writer.LogContainerWriter
import com.delbel.zygote.writer.LogContentWriter
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val featureName = "feature"
    val featurePackage = "com.delbel.zygote"

    val feature = Feature(name = featureName, basePackage = featurePackage)
    val featureFile = File(root(), featureName)

    val domain = Module(
        name = "domain",
        feature = feature,
        buildGradle = DomainGradleFile()
    )
    val gateway = Module(
        name = "gateway",
        feature = feature,
        buildGradle = GatewayGradleFile(),
        innerDependencies = listOf(domain)
    )
    val presentation = Module(
        name = "presentation",
        feature = feature,
        buildGradle = PresentationGradleFile(),
        innerDependencies = listOf(domain)
    )

    listOf(domain, presentation, gateway).forEach { module -> module.create(
        containerWriter = DirectoryContainerWriter(root = featureFile),
        contentWriter = FileContentWriter(root = featureFile))
    }
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}