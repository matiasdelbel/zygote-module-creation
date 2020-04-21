package com.delbel.zygote.feature

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.feature.module.SourceMain
import com.delbel.zygote.feature.module.SourceTest
import com.delbel.zygote.feature.module.gradle.BuildGradle
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.writer.Writeable
import com.delbel.zygote.writer.Writer

open class Module(
    private val parent: String,
    private val name: String,
    private val buildGradle: BuildGradle,
    private val sourceMain: SourceMain? = null,
    private val sourceTest: SourceTest? = null
) : Writeable {

    private val proGuard = ProGuard()
    private val gitIgnore = GitIgnore()

    override fun <T> create(writer: Writer<T>) {
        val moduleWriter = writer.visit(module = this)

        proGuard.create(moduleWriter)
        gitIgnore.create(moduleWriter)

        sourceMain?.create(moduleWriter)
        sourceTest?.create(moduleWriter)

        // TODO append on settings.gradle.kts the module
    }

    fun path() = "$parent/$name"
}

class DomainModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "domain",
    buildGradle = DomainBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)

class GatewayModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "gateway",
    buildGradle = DomainBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)

class PresentationModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "presentation",
    buildGradle = DomainBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)