package com.delbel.zygote.module

import com.delbel.zygote.module.content.dynamic.*
import com.delbel.zygote.module.content.dynamic.gradle.GradleFile
import com.delbel.zygote.module.content.hard.GitIgnoreFile
import com.delbel.zygote.module.content.hard.HardContent
import com.delbel.zygote.module.content.hard.MockMarkerFile
import com.delbel.zygote.module.content.hard.ProGuardFile
import com.delbel.zygote.module.content.source.MainSource
import com.delbel.zygote.module.content.source.Source
import com.delbel.zygote.module.content.source.TestSource
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

    fun relativePathFor(file: HardContent) = file.pathIn(module = this)

    fun relativePathFor(file: ProGuardFile) = "$name/${file.name}"

    fun relativePathFor(file: GitIgnoreFile) = "$name/${file.name}"

    fun relativePathFor(file: MockMarkerFile) = "${resourcesPathFor(sourceTest)}/${file.name}"

    fun relativePathFor(file: DynamicContent) = file.pathIn(module = this)

    fun relativePathFor(file: GradleFile) = "$name/${file.name}"

    fun relativePathFor(file: ManifestFile) = "${srcPathFor(sourceMain)}/${file.name}"

    fun relativePathFor(file: SettingsFile) = file.name

    fun relativePathFor(source: Source) = "$name/${source.src()}/kotlin/${feature.basePackage.split(".").joinToString("/")}/$name"

    fun contentFor(file: DynamicContent) = file.content(module = this)

    fun contentFor(file: ManifestFile) = file.content(packageName = "${feature.basePackage}.${feature.name}.$name")

    fun contentFor(file: GradleFile) = file.content(innerDependencies = innerDependencies.map { ":${feature.name}:$name" })

    fun contentFor(file: SettingsFile) = file.content(moduleName = ":${feature.name}:$name", modulePath = "${feature.name}/$name")

    fun create(containerWriter: ContainerWriter, contentWriter: ContentWriter) {
        containerWriter.create(name)

        proGuard.write(contentWriter, module = this)
        gitIgnore.write(contentWriter, module = this)
        buildGradle.write(contentWriter, module = this)

        sourceMain.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)
        sourceTest.write(containerWriter = containerWriter, contentWriter = contentWriter, module = this)
    }

    private fun resourcesPathFor(source: Source) = "$name/${source.resources()}"

    private fun srcPathFor(source: Source) = "$name/${source.src()}"
}