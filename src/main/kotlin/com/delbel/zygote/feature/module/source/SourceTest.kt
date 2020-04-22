package com.delbel.zygote.feature.module.source

import com.delbel.zygote.feature.content.hard.MockMarkerFile
import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class SourceTest : ModuleWriteable {

    val mockMarkerFile = MockMarkerFile()

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(sourceTest = this)

    fun sourcePath() = "$SOURCE_FOLDER/$CODE_FOLDER"

    companion object {
        private const val SOURCE_FOLDER = "src/test"

        private const val CODE_FOLDER = "kotlin"
    }
}