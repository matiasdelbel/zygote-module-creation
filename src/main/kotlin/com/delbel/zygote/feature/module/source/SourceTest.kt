package com.delbel.zygote.feature.module.source

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class SourceTest() : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(sourceTest = this)

    fun sourcePath() = "$SOURCE_FOLDER/$CODE_FOLDER"

    fun mockMarkerPath() = MOCK_MARKER_PATH

    companion object {
        private const val SOURCE_FOLDER = "src/test"

        private const val CODE_FOLDER = "kotlin"
        private const val RESOURCES_FOLDER = "resources"

        private const val MOCK_MARKER_PATH = "$SOURCE_FOLDER/$RESOURCES_FOLDER/mockito-extensions/org.mockito.plugins.MockMaker"
    }
}