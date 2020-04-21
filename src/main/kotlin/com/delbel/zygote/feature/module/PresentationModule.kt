package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class PresentationModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "presentation",
    buildGradle = PresentationBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)