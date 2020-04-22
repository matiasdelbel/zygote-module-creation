package com.delbel.zygote.feature.content

import com.delbel.zygote.writer.FileWriter

interface StaticContent {

    val name: String

    fun writeContent(writer: FileWriter)
}