package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.files.GitIgnore
import com.delbel.zygote.feature.module.files.ProGuard
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import com.delbel.zygote.feature.module.gradle.BuildGradle
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

abstract class Module(
    val name: String,
    private val sourceMain: SourceMain? = null,
    private val sourceTest: SourceTest? = null
) : Writeable {

    private val proGuard = ProGuard()
    private val gitIgnore = GitIgnore()

    protected abstract val buildGradle: BuildGradle

    override fun <T> create(writer: Writer<T>) {
        val moduleWriter = writer.visit(module = this)

        proGuard.create(moduleWriter)
        gitIgnore.create(moduleWriter)
        buildGradle.create(moduleWriter)

        sourceMain?.create(moduleWriter)
        sourceTest?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }
}