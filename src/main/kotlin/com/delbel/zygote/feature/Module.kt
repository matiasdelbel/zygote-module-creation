package com.delbel.zygote.feature

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
    val name: String,
    private val feature: Feature,
    private val buildGradle: GradleFile,
    private val innerDependencies: List<Module> = emptyList()
) {

    private val proGuard = ProGuardFile()
    private val gitIgnore = GitIgnoreFile()

    private val sourceMain: MainSource = MainSource()
    private val sourceTest: TestSource = TestSource()

    fun contentFor(file: DynamicContent) = file.content(module = this)

    fun contentFor(file: ManifestFile) = file.content(packageName = feature.packageNameFor(module = this))

    fun contentFor(file: GradleFile) = file.content(innerDependencies = innerDependencies.map {
        feature.dependencyNameFor(module = this)
    })

    fun pathFor(source: Source) = feature.sourcePathFor(module = this, source = source)

    fun create(containerWriter: ContainerWriter, contentWriter: ContentWriter) {
        proGuard.write(contentWriter)
        gitIgnore.write(contentWriter)
        buildGradle.write(contentWriter, module = this)

        sourceMain.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)
        sourceTest.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)

        // TODO update settings file
    }
}