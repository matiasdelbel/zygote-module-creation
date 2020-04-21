package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.feature.module.SourceTest
import java.lang.StringBuilder

class StringModuleWriter(parent: String) : ModuleWriter<String>(parent) {

    private val featureBuilder = StringBuilder()

    override fun visit(proguard: ProGuard) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/${proguard.name}")
    }

    override fun visit(gitIgnore: GitIgnore) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/${gitIgnore.name}")
    }

    override fun visit(sourceTest: SourceTest) {
        featureBuilder.appendln()
        var sourcePath = sourceTest.sourcePath()
        sourceTest.packages().forEach { sourcePath = "$sourcePath/$it" }
        featureBuilder.append("${parent}/$sourcePath")

        featureBuilder.appendln()
        featureBuilder.append("${parent}/${sourceTest.mockMarkerPath()}")
    }

    fun test(): String = featureBuilder.toString()
}