package com.delbel.zygote

import com.delbel.zygote.feature.*
import com.delbel.zygote.feature.module.DomainModule
import com.delbel.zygote.feature.module.GatewayModule
import com.delbel.zygote.feature.module.PresentationModule
import com.delbel.zygote.writer.FileWriterDeprecated
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val domain = DomainModule()
    val gateway = GatewayModule(dependencies = listOf(domain))
    val presentation = PresentationModule(dependencies = listOf(domain))
    val feature = Feature(modules = listOf(domain, gateway, presentation))

    val writer = FileWriterDeprecated(featureName = "feature", packageName = "com.delbel.zygote", root = root())

    feature.create(writer)
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}