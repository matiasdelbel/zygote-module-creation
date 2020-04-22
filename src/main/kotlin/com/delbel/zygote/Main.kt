package com.delbel.zygote

import com.delbel.zygote.feature.*
import com.delbel.zygote.feature.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.GatewayGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.feature.Module
import com.delbel.zygote.writer.DirectoryContainerWriter
import com.delbel.zygote.writer.FileContentWriter
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
        innerDependencies = listOf(domain)
    )
    val presentation = Module(
        feature = "feature",
        name = "presentation",
        packageName = "com.delbel.zygote",
        buildGradle = PresentationGradleFile(),
        innerDependencies = listOf(domain)
    )
    val feature = Feature(name = "feature", modules = listOf(domain, gateway, presentation))

    feature.create(DirectoryContainerWriter(root = root()), FileContentWriter(root = root()))
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}