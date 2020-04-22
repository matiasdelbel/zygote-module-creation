package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.DomainGradleFile
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class DomainModule : Module(
    name = "domain",
    sourceMain = SourceMain(),
    sourceTest = SourceTest()
) {

    override val buildGradle2 = DomainGradleFile()
}
