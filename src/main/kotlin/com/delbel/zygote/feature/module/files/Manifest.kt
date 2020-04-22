package com.delbel.zygote.feature.module.files

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class Manifest : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(manifest = this)

    fun relativePath() = "$SOURCE_FOLDER/$CODE_FOLDER/AndroidManifest.xml"

    fun asString(packageName: String) =
        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"

    companion object {
        private const val SOURCE_FOLDER = "src/main"

        private const val CODE_FOLDER = "kotlin"
    }
}