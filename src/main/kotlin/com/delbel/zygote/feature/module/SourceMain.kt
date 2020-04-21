package com.delbel.zygote.feature.module

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class SourceMain(private val packageName: String) : ModuleWriteable {

    private val manifest = Manifest(packageName)

    override fun <T> create(writer: ModuleWriter<T>) {
        writer.visit(sourceMain = this)
        manifest.create(writer)
    }

    fun packages() = packageName.split(".")

    fun sourcePath() = "$SOURCE_FOLDER/$CODE_FOLDER"

    companion object {
        private const val SOURCE_FOLDER = "src/main"

        private const val CODE_FOLDER = "kotlin"
    }
}