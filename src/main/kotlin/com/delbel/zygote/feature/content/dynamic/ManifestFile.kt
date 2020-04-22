package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.module.Module

class ManifestFile : DynamicContent() {

    override val name: String = "src/main/kotlin/AndroidManifest.xml"

    override fun content(module: Module) = module.contentFor(file = this)

    fun content(packageName: String) =
        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"
}