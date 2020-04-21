package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
import com.delbel.zygote.feature.module.SourceTest
import java.lang.StringBuilder

class StringModuleWriter(parent: String) : ModuleWriter<String>(parent) {

    private val featureBuilder = StringBuilder()

    override fun visit(proguard: ProGuard) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/proguard-rules.pro")
    }

    override fun visit(gitIgnore: GitIgnore) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/.gitignore")
    }

    override fun visit(sourceTest: SourceTest) {
        featureBuilder.appendln()
        featureBuilder.append("${parent}/${sourceTest.resourcesPath()}/mockito-extensions/org.mockito.plugins.MockMaker")
    }

    fun test(): String = featureBuilder.toString()
}