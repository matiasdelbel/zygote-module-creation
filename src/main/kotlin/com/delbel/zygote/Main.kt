package com.delbel.zygote

import com.delbel.zygote.feature.*
import com.delbel.zygote.feature.module.DomainModule
import com.delbel.zygote.feature.module.GatewayModule
import com.delbel.zygote.feature.module.PresentationModule
import com.delbel.zygote.writer.FileWriter
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val domain = DomainModule(parent = "feature", packageRoot = "com.delbel.zygote")
    val gateway = GatewayModule(parent = "feature", packageRoot = "com.delbel.zygote")
    val presentation = PresentationModule(parent = "feature", packageRoot = "com.delbel.zygote")

    val feature = Feature(name = "feature", modules = listOf(domain, gateway, presentation))
    val writer = FileWriter(root = root())

    feature.create(writer)
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}