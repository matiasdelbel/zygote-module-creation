package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.module.Module
import java.lang.StringBuilder

class GatewayGradleFile : DynamicContent() {

    override val name: String = "build.gradle.kts"

    override fun accept(module: Module): String = module.visit(file = this)

    fun content(feature: String, innerDependencies: List<Module>): String {
        val fileBuilder = StringBuilder()
        fileBuilder.appendln("plugins {")
        fileBuilder.appendln("    id(\"com.android.library\")")
        fileBuilder.appendln("    id(\"project-module-plugin\")")
        fileBuilder.appendln("}")
        fileBuilder.appendln()
        fileBuilder.appendln("dependencies {")
        innerDependencies.forEach {
            fileBuilder.appendln("    implementation(project(path = \":$feature:${it.name}\"))")
        }
        fileBuilder.appendln("}")

        return fileBuilder.toString()
    }
}