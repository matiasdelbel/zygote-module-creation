package com.delbel.zygote

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.module.SourceMain
import com.delbel.zygote.feature.module.SourceTest
import com.delbel.zygote.writer.FileWriter
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val domain = Module(
        parent = "feature",
        name = "domain",
        sourceMain = SourceMain(packageName = "com.delbel.zygote.domain"),
        sourceTest = SourceTest(packageName = "com.delbel.zygote.domain")
    )
    val gateway = Module(
        parent = "feature",
        name = "gateway",
        sourceMain = SourceMain(packageName = "com.delbel.zygote.gateway"),
        sourceTest = SourceTest(packageName = "com.delbel.zygote.gateway")
    )
    val presentation = Module(
        parent = "feature",
        name = "presentation",
        sourceMain = SourceMain(packageName = "com.delbel.zygote.presentation"),
        sourceTest = SourceTest(packageName = "com.delbel.zygote.presentation")
    )
    val feature = Feature(
        name = "feature",
        modules = listOf(domain, gateway, presentation)
    )
    val writer = FileWriter(root = root())

    feature.create(writer)
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}