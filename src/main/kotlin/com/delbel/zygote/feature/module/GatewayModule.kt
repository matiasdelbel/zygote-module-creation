package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class GatewayModule(parent: String, packageRoot: String) : Module(
    parent = parent,
    name = "gateway",
    buildGradle = GatewayBuildGradle(),
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.domain"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.domain")
)