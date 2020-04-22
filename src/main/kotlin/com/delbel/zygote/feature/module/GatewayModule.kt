package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class GatewayModule(parent: String, packageRoot: String, dependencies: List<Module> = emptyList()) : Module(
    parent = parent,
    name = "gateway",
    sourceMain = SourceMain(packageName = "$packageRoot.$parent.gateway"),
    sourceTest = SourceTest(packageName = "$packageRoot.$parent.gateway")
) {
    override val buildGradle = GatewayBuildGradle(parent, dependencies)
}