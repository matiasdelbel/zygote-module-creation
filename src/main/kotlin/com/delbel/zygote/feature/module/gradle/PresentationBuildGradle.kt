package com.delbel.zygote.feature.module.gradle

import com.delbel.zygote.feature.module.Module
import com.delbel.zygote.writer.ModuleWriter

class PresentationBuildGradle(
    private val dependencies: List<Module> = emptyList()
) : BuildGradle {

    override fun relativePath(): String = "build.gradle.kts"

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(buildGradle = this)

    fun asString(moduleName: String) = "plugins {\n" +
            "    id(\"com.android.library\")\n" +
            "    id(\"project-module-plugin\")\n" +
            "}\n" +
            "\n" +
            "dependencies {" + dependencies(moduleName) + "}"

    private fun dependencies(moduleName: String): String {
        val dependenciesList = StringBuffer()
        dependenciesList.appendln()
        dependencies.forEach {
            dependenciesList.appendln("    implementation(project(path = \":$moduleName:${it.name}\"))")
        }
        return dependenciesList.toString()
    }
}