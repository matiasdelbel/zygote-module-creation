package com.delbel.zygote

import com.delbel.zygote.module.*
import com.delbel.zygote.module.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.module.content.dynamic.gradle.GatewayGradleFile
import com.delbel.zygote.module.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.module.Module
import com.delbel.zygote.module.content.dynamic.SettingsFile
import com.delbel.zygote.writer.DirectoryContainerWriter
import com.delbel.zygote.writer.FileContentWriter
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val feature = Feature(name = "feature", basePackage = "com.delbel.zygote")
    val settings = SettingsFile()

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

    listOf(domain, presentation, gateway).forEach { module ->
        module.create(
            containerWriter = DirectoryContainerWriter(root = File(root(), "feature")),
            contentWriter = FileContentWriter(root = File(root(), "feature"))
        )

        settings.write(writer = FileContentWriter(root = root()), module = module)
    }
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}