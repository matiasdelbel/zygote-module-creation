package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.DomainGradleFile
import com.delbel.zygote.feature.content.dynamic.DynamicContent
import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.content.dynamic.PresentationGradleFile
import com.delbel.zygote.feature.content.hard.GitIgnoreFile
import com.delbel.zygote.feature.content.hard.ProGuardFile
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import com.delbel.zygote.feature.module.gradle.BuildGradle
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

abstract class Module(
    val feature: String,
    val packageName: String,
    val name: String,
    private val sourceMain: SourceMain? = null,
    private val sourceTest: SourceTest? = null,
    private val dependencies: List<Module> = emptyList()
) : Writeable {

    private val proGuard = ProGuardFile()
    private val gitIgnore = GitIgnoreFile()

    fun visit(file: DynamicContent): String = file.accept(module = this)

    fun visit(file: ManifestFile): String = file.content(packageName = modulePackage())

    fun visit(file: DomainGradleFile): String = file.content()

    fun visit(file: PresentationGradleFile): String = file.content(feature = feature, innerDependencies = dependencies)

    private fun modulePackage() = "$packageName.$feature.$name"

    // TODO all deprecated
    protected open val buildGradle: BuildGradle? = null
    open val buildGradle2: DynamicContent? = null

    override fun <T> create(writer: Writer<T>) {
        val (moduleWriter, staticWriter) = writer.visit(module = this)

        buildGradle?.create(moduleWriter)

        proGuard.write(staticWriter)
        gitIgnore.write(staticWriter)

        sourceMain?.create(moduleWriter)
        sourceTest?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }
}