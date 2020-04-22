package com.delbel.zygote.feature.module.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class SourceMain() : ModuleWriteable {

    val manifest = ManifestFile()

    override fun <T> create(writer: ModuleWriter<T>) {
        writer.visit(sourceMain = this)
    }

    fun sourcePath() = "$SOURCE_FOLDER/$CODE_FOLDER"

    companion object {
        private const val SOURCE_FOLDER = "src/main"

        private const val CODE_FOLDER = "kotlin"
    }
}