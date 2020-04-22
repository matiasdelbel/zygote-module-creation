package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

abstract class ModuleWriter<T>(protected val moduleContainer: T, protected val packageName: String) {

    abstract fun visit(sourceMain: SourceMain)

    abstract fun visit(sourceTest: SourceTest)

    abstract fun visit(buildGradle: DomainBuildGradle)

    abstract fun visit(buildGradle: GatewayBuildGradle)

    abstract fun visit(buildGradle: PresentationBuildGradle)
}

interface ModuleWriteable {

    fun <T> create(writer: ModuleWriter<T>)
}