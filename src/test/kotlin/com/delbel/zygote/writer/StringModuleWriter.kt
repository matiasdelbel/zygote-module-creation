package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.files.GitIgnore
import com.delbel.zygote.feature.module.files.Manifest
import com.delbel.zygote.feature.module.files.ProGuard
import com.delbel.zygote.feature.module.gradle.DomainBuildGradle
import com.delbel.zygote.feature.module.gradle.GatewayBuildGradle
import com.delbel.zygote.feature.module.gradle.PresentationBuildGradle
import com.delbel.zygote.feature.module.source.SourceMain
import com.delbel.zygote.feature.module.source.SourceTest
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

    override fun visit(sourceMain: SourceMain) {
        featureBuilder.appendln()
        var sourcePath = sourceMain.sourcePath()
        sourceMain.packages().forEach { sourcePath = "$sourcePath/$it" }
        featureBuilder.append("${parent}/$sourcePath")
    }

    override fun visit(sourceTest: SourceTest) {
        featureBuilder.appendln()
        var sourcePath = sourceTest.sourcePath()
        sourceTest.packages().forEach { sourcePath = "$sourcePath/$it" }
        featureBuilder.append("${parent}/$sourcePath")

        featureBuilder.appendln()
        featureBuilder.append("${parent}/${sourceTest.mockMarkerPath()}")
    }

    override fun visit(manifest: Manifest) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/${manifest.relativePath()}")
        featureBuilder.append(" (package = ${manifest.packageName})")
    }

    fun test(): String = featureBuilder.toString()
    override fun visit(buildGradle: DomainBuildGradle) {
        TODO("not implemented")
    }

    override fun visit(buildGradle: GatewayBuildGradle) {
        TODO("not implemented")
    }

    override fun visit(buildGradle: PresentationBuildGradle) {
        TODO("not implemented")
    }
}