package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class PresentationModule(parent: String, packageRoot: String, dependencies: List<Module> = emptyList()) : Module(
    parent = parent,
    name = "presentation",
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.presentation"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.presentation")
) {
    override val buildGradle = PresentationBuildGradle(parent, dependencies)
}