package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.Module
import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.content.hard.MockMarkerFile
import com.delbel.zygote.writer.ContentWriter

class TestSource : Source() {

    override val manifest: ManifestFile? = null

    private val mockMarkerFile = MockMarkerFile()

    override fun src() = "src/test"

    override fun resources() = "src/test/resources"

    override fun writeCustomContent(contentWriter: ContentWriter, module: Module) = mockMarkerFile.write(contentWriter, module)
}