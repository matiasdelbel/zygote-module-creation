package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class PresentationModule(dependencies: List<Module> = emptyList()) : Module(
    name = "presentation",
    sourceMain = SourceMain(),
    sourceTest = SourceTest()
) {
    override val buildGradle = PresentationBuildGradle(dependencies)
}