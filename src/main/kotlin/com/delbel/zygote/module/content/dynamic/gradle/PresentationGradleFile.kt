package com.delbel.zygote.module.content.dynamic.gradle

import com.delbel.zygote.module.Module
import java.lang.StringBuilder

class PresentationGradleFile : GradleFile() {

    override val name: String = "build.gradle.kts"

    override fun content(module: Module) = module.contentFor(file = this)

    override fun content(innerDependencies: List<String>): String {
        val fileBuilder = StringBuilder()
        fileBuilder.appendln("plugins {")
        fileBuilder.appendln("    id(\"com.android.library\")")
        fileBuilder.appendln("    id(\"project-module-plugin\")")
        fileBuilder.appendln("}")
        fileBuilder.appendln()
        fileBuilder.appendln("android { viewBinding { isEnabled = true } }")
        fileBuilder.appendln()
        if (innerDependencies.isNotEmpty()) {
            fileBuilder.appendln("dependencies {")
            innerDependencies.forEach { fileBuilder.appendln("    implementation(project(path = \"$it))") }
            fileBuilder.appendln("}")
        }

        return fileBuilder.toString()
    }
}