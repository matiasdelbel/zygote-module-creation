package com.delbel.zygote.writer

import com.delbel.zygote.feature.Feature
import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.top.GitIgnore
import com.delbel.zygote.feature.top.ProGuard
import java.lang.StringBuilder

class StringWriter(root: String) : Writer<String>(root) {

    private val featureBuilder = StringBuilder().apply { append(root) }

    override fun visit(feature: Feature) {
        featureBuilder.append(feature.name)
    }

    override fun visit(module: Module) {
        featureBuilder.appendln()
        featureBuilder.append("    |_ ${module.name}")
    }

    override fun visit(proguard: ProGuard) {
        featureBuilder.appendln()
        featureBuilder.append("        |_ proguard-rules.pro")
    }

    override fun visit(gitIgnore: GitIgnore) {
        featureBuilder.appendln()
        featureBuilder.append("        |_ .gitignore")
    }

    fun test(): String = featureBuilder.toString()
}