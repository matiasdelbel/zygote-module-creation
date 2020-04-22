package com.delbel.zygote.feature.module

import com.delbel.zygote.feature.content.dynamic.PresentationGradleFile
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest

class PresentationModule(dependencies: List<Module> = emptyList(), packageName: String, feature: String) : Module(
    feature = feature,
    name = "presentation",
    packageName = packageName,
    sourceMain = SourceMain(),
    sourceTest = SourceTest(),
    dependencies = dependencies
) {
    override val buildGradle2 = PresentationGradleFile()
}