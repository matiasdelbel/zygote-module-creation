package com.delbel.zygote.feature.content.dynamic

data class ContentContext(private val feature: String, private val module: String, private val packageName: String) {

    fun visit(content: DynamicContent): String = content.accept(context = this)

    fun visit(content: ManifestFile): String = content.content(packageName = modulePackage())

    fun visit(content: DomainGradleFile): String = content.content()

    private fun modulePackage() = "$packageName.$feature.$module"
}