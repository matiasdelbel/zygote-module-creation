package com.delbel.zygote.writer

import com.delbel.zygote.feature.module.GitIgnore
import com.delbel.zygote.feature.module.ProGuard
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

    fun test(): String = featureBuilder.toString()
}