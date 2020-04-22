package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
import java.lang.StringBuilder

class StringModuleWriter(parent: String) : ModuleWriter<String>(parent, "") {

    private val featureBuilder = StringBuilder()

    override fun visit(sourceMain: SourceMain) {
        featureBuilder.appendln()
        var sourcePath = sourceMain.sourcePath()
        //sourceMain.packages().forEach { sourcePath = "$sourcePath/$it" }
        //featureBuilder.append("${moduleContainer}/$sourcePath")
    }

    override fun visit(sourceTest: SourceTest) {
        featureBuilder.appendln()
        var sourcePath = sourceTest.sourcePath()
        //sourceTest.packages().forEach { sourcePath = "$sourcePath/$it" }
        featureBuilder.append("${moduleContainer}/$sourcePath")

        featureBuilder.appendln()
        //featureBuilder.append("${moduleContainer}/${sourceTest.mockMarkerPath()}")
    }

    fun test(): String = featureBuilder.toString()

    override fun visit(buildGradle: GatewayBuildGradle) {
        TODO("not implemented")
    }
}