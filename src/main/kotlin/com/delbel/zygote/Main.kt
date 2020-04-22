package com.delbel.zygote

import com.delbel.zygote.feature.*
import com.delbel.zygote.feature.content.dynamic.DomainGradleFile
import com.delbel.zygote.feature.content.dynamic.GatewayGradleFile
import com.delbel.zygote.feature.content.dynamic.PresentationGradleFile
import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.FileWriterDeprecated
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val domain = Module(
        feature = "feature",
        name = "domain",
        packageName = "com.delbel.zygote",
        buildGradle = DomainGradleFile()
    )
    val gateway = Module(
        feature = "feature",
        name = "gateway",
        packageName = "com.delbel.zygote",
        buildGradle = GatewayGradleFile(),
        dependencies = listOf(domain))
    val presentation = Module(
        feature = "feature",
        name = "presentation",
        packageName = "com.delbel.zygote",
        buildGradle = PresentationGradleFile(),
        dependencies = listOf(domain))

    val feature = Feature(modules = listOf(domain, gateway, presentation))

    val writer = FileWriterDeprecated(
        featureName = "feature",
        packageName = "com.delbel.zygote",
        root = root()
    )

    feature.create(writer)
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}