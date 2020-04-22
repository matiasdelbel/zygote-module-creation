package com.delbel.zygote.feature.content.source

import com.delbel.zygote.feature.content.dynamic.ManifestFile
import com.delbel.zygote.feature.content.hard.MockMarkerFile
import com.delbel.zygote.writer.ContentWriter

class TestSource : Source() {

    override val manifest: ManifestFile? = null

    private val mockMarkerFile = MockMarkerFile()

    override fun path() = "src/test/kotlin"

    override fun writeCustomContent(contentWriter: ContentWriter) = mockMarkerFile.write(contentWriter)
}