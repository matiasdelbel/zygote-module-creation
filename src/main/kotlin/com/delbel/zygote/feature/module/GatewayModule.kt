package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class GatewayModule(dependencies: List<Module> = emptyList()) : Module(
    name = "gateway",
    sourceMain = SourceMain(),
    sourceTest = SourceTest()
) {
    override val buildGradle = GatewayBuildGradle(dependencies)
}