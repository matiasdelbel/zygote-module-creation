package com.delbel.zygote.feature.module.gradle

import com.delbel.zygote.writer.ModuleWriter

class DomainBuildGradle(private val parent: String) : BuildGradle {

    override fun relativePath(): String = "build.gradle.kts"

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(buildGradle = this)

    fun asString() = "plugins {\n" +
            "    id(\"com.android.library\")\n" +
            "    id(\"project-module-plugin\")\n" +
            "}"
}