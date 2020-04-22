package com.delbel.zygote.feature.module.gradle

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.ModuleWriter

class PresentationBuildGradle(
    private val parent: String,
    private val dependencies: List<Module> = emptyList()
) : BuildGradle {

    override fun relativePath(): String = "build.gradle.kts"

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(buildGradle = this)

    fun asString() = "plugins {\n" +
            "    id(\"com.android.library\")\n" +
            "    id(\"project-module-plugin\")\n" +
            "}\n" +
            "\n" +
            "dependencies {" + dependencies() + "}"

    private fun dependencies(): String {
        val dependenciesList = StringBuffer()
        dependenciesList.appendln()
        dependencies.forEach {
            dependenciesList.appendln("    implementation(project(path = \":$parent:${it.name}\"))")
        }
        return dependenciesList.toString()
    }
}