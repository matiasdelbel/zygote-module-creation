package com.delbel.zygote.feature.content.dynamic

class ManifestFile : DynamicContent() {

    override val name: String = "src/main/kotlin/AndroidManifest.xml"

    override fun accept(context: ContentContext): String = context.visit(content = this)

    fun content(packageName: String) =
        "<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\" package=\"$packageName\"/>"
}