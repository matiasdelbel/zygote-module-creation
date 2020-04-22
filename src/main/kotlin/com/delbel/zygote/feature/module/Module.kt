package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.*
import com.delbel.zygote.feature.content.dynamic.gradle.DomainGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.GatewayGradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.GradleFile
import com.delbel.zygote.feature.content.dynamic.gradle.PresentationGradleFile
import com.delbel.zygote.feature.content.hard.GitIgnoreFile
import com.delbel.zygote.feature.content.hard.ProGuardFile
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

class Module(
    val feature: String,
    val name: String,
    val packageName: String,
    private val buildGradle: GradleFile,
    private val dependencies: List<Module> = emptyList(),

    private val sourceMain: SourceMain? = SourceMain(),
    private val sourceTest: SourceTest? = SourceTest()
) : Writeable {

    private val proGuard = ProGuardFile()
    private val gitIgnore = GitIgnoreFile()

    fun visit(file: DynamicContent): String = file.accept(module = this)

    fun visit(file: ManifestFile): String = file.content(packageName = "$packageName.$feature.$name")

    fun visit(file: GradleFile): String = file.content(innerDependencies = dependencies.map { "$feature:${it.name}" })

    // TODO all deprecated

    override fun <T> create(writer: Writer<T>) {
        val (moduleWriter, staticWriter) = writer.visit(module = this)

        proGuard.write(staticWriter)
        gitIgnore.write(staticWriter)

        buildGradle.write(staticWriter, this)

        sourceMain?.create(moduleWriter)
        sourceTest?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }
}