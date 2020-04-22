package com.delbel.zygote.feature.content.dynamic

class DomainGradleFile : DynamicContent() {

    override val name: String = "build.gradle.kts"

    override fun accept(context: ContentContext): String = context.visit(content = this)

    fun content() = "plugins {\n" +
            "    id(\"com.android.library\")\n" +
            "    id(\"project-module-plugin\")\n" +
            "}"
}
