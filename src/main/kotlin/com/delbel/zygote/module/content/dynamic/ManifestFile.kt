package com.delbel.zygote.module.content.dynamic

import com.delbel.zygote.module.Module

class ManifestFile : DynamicContent() {

    override val name: String = "AndroidManifest.xml"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)

    override fun content(module: Module) = module.contentFor(file = this)

    fun content(packageName: String) =
        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"
}