package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class GatewayModule(dependencies: List<Module> = emptyList(), packageName: String, feature: String) : Module(
    feature = feature,
    name = "gateway",
    packageName = packageName,
    sourceMain = SourceMain(),
    sourceTest = SourceTest(),
    dependencies = dependencies
) {
    override val buildGradle = GatewayBuildGradle(dependencies)
}