package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.files.GitIgnore
import com.delbel.zygote.feature.module.files.Manifest
import com.delbel.zygote.feature.module.files.ProGuard
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

abstract class ModuleWriter<T>(protected val parent: T) {

    abstract fun visit(proguard: ProGuard)

    abstract fun visit(gitIgnore: GitIgnore)

    abstract fun visit(sourceMain: SourceMain)

    abstract fun visit(sourceTest: SourceTest)

    abstract fun visit(manifest: Manifest)

    abstract fun visit(buildGradle: DomainBuildGradle)

    abstract fun visit(buildGradle: GatewayBuildGradle)

    abstract fun visit(buildGradle: PresentationBuildGradle)
}

interface ModuleWriteable {

    fun <T> create(writer: ModuleWriter<T>)
}