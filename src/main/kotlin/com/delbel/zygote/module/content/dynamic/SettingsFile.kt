package com.delbel.zygote.module.content.dynamic

import com.delbel.zygote.module.Module
import com.delbel.zygote.writer.ContentWriter
import java.lang.StringBuilder

class SettingsFile : DynamicContent() {

    override val name: String = "settings.gradle.kts"

    override fun write(writer: ContentWriter, module: Module) = writer.append(
        targetName = module.relativePathFor(file = this),
        content = module.contentFor(file = this)
    )

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    override fun content(module: Module) = module.contentFor(file = this)

    fun content(moduleName: String, modulePath: String): String {
        val fileBuilder = StringBuilder()

        fileBuilder.appendln()
        fileBuilder.appendln("include(\"$moduleName\")")
        fileBuilder.appendln("project(path = \"$moduleName\").projectDir = File(rootDir, \"$modulePath\")")

        return fileBuilder.toString()
    }
}