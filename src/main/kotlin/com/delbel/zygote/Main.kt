package com.delbel.zygote

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.module.SourceTest
import com.delbel.zygote.writer.FileWriter
import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    val domain = Module(
        parent = "feature",
        name = "domain",
        sourceTest = SourceTest(packageName = "com.delbel.zygote")
    )
    val feature = Feature(
        name = "feature",
        modules = listOf(domain)
    )
    val writer = FileWriter(root = root())

    feature.create(writer)
}

private fun root(): File {
    val path = Paths.get("").toAbsolutePath().toString()
    return File(path)
}