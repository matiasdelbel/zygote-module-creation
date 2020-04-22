package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.*
import com.delbel.zygote.feature.content.dynamic.gradle.GradleFile
import com.delbel.zygote.feature.content.hard.GitIgnoreFile
import com.delbel.zygote.feature.content.hard.ProGuardFile
import com.delbel.zygote.feature.content.source.MainSource
import com.delbel.zygote.feature.content.source.Source
import com.delbel.zygote.feature.content.source.TestSource
import com.delbel.zygote.writer.ContainerWriter
import com.delbel.zygote.writer.ContentWriter

class Module(
    val feature: String,
    val name: String,
    val packageName: String,
    private val buildGradle: GradleFile,
    private val innerDependencies: List<Module> = emptyList()
) {

    private val proGuard = ProGuardFile()
    private val gitIgnore = GitIgnoreFile()

    private val sourceMain: MainSource = MainSource()
    private val sourceTest: TestSource = TestSource()

    fun visit(file: DynamicContent): String =
        file.accept(module = this)

    fun visit(file: ManifestFile): String =
        file.content(packageName = "$packageName.$feature.$name")

    fun visit(file: GradleFile): String =
        file.content(innerDependencies = innerDependencies.map { "$feature:${it.name}" })

    fun visit(source: Source): String =
        "${source.path(module = this)}${packageName.split(".").joinToString("/")}"

    fun create(containerWriter: ContainerWriter, contentWriter: ContentWriter) {
        proGuard.write(contentWriter)
        gitIgnore.write(contentWriter)
        buildGradle.write(contentWriter, module = this)

        sourceMain.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)
        sourceTest.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)
    }
}