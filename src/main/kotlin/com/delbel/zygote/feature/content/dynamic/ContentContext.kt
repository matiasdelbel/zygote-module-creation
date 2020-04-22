package com.delbel.zygote.feature.content.dynamic

data class ContentContext(private val feature: String, private val module: String, private val packageName: String) {

    fun visit(content: DynamicContent): String = content.accept(context = this)
}