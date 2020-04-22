package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.module.Module
import java.lang.StringBuilder

class DomainGradleFile : DynamicContent() {

    override val name: String = "build.gradle.kts"

    override fun accept(module: Module): String = module.visit(file = this)

    fun content(): String {
        val fileBuilder = StringBuilder()
        fileBuilder.appendln("plugins {")
        fileBuilder.appendln("    id(\"com.android.library\")")
        fileBuilder.appendln("    id(\"project-module-plugin\")")
        fileBuilder.appendln("}")

        return fileBuilder.toString()
    }
}
