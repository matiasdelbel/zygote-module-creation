package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.DomainGradleFile
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class DomainModule(packageName: String, feature: String) : Module(
    feature = feature,
    packageName = packageName,
    name = "domain",
    sourceMain = SourceMain(),
    sourceTest = SourceTest()
) {

    override val buildGradle = DomainGradleFile()
}
