package com.delbel.zygote.feature.module

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class Manifest(val packageName: String) : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(manifest = this)

    fun relativePath() = "${SOURCE_FOLDER}/${CODE_FOLDER}/AndroidManifest.xml"

    fun asString() = "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"

    companion object {
        private const val SOURCE_FOLDER = "src/main"

        private const val CODE_FOLDER = "kotlin"
    }
}