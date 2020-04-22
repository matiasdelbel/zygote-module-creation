package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.hard.GitIgnoreFile
import com.delbel.zygote.feature.content.hard.ProGuardFile
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import com.delbel.zygote.feature.module.gradle.BuildGradle
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

abstract class Module(
    val name: String,
    private val sourceMain: SourceMain? = null,
    private val sourceTest: SourceTest? = null
) : Writeable {

    private val proGuard = ProGuardFile()
    private val gitIgnore = GitIgnoreFile()

    protected abstract val buildGradle: BuildGradle

    override fun <T> create(writer: Writer<T>) {
        val (moduleWriter, staticWriter) = writer.visit(module = this)

        buildGradle.create(moduleWriter)

        proGuard.write(staticWriter)
        gitIgnore.write(staticWriter)

        sourceMain?.create(moduleWriter)
        sourceTest?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }
}