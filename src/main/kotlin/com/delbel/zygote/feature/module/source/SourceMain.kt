package com.delbel.zygote.feature.module.source

import com.delbel.zygote.feature.module.files.Manifest
import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class SourceMain() : ModuleWriteable {

    private val manifest = Manifest()

    override fun <T> create(writer: ModuleWriter<T>) {
        writer.visit(sourceMain = this)
        manifest.create(writer)
    }

    fun sourcePath() = "$SOURCE_FOLDER/$CODE_FOLDER"

    companion object {
        private const val SOURCE_FOLDER = "src/main"

        private const val CODE_FOLDER = "kotlin"
    }
}