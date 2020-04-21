package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class DomainModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "domain",
    buildGradle = DomainBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)
