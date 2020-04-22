package com.delbel.zygote.feature.content.dynamic

import com.delbel.zygote.feature.Module

class ManifestFile : DynamicContent() {

    override val name: String = "AndroidManifest.xml"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    override fun content(module: Module) = module.contentFor(file = this)

    fun content(packageName: String) =
        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"
}