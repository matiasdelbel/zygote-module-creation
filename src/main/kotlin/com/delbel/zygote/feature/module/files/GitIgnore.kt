package com.delbel.zygote.feature.module.files

import com.delbel.zygote.writer.ModuleWriteable
import com.delbel.zygote.writer.ModuleWriter

class GitIgnore(val name: String = ".gitignore") : ModuleWriteable {

    override fun <T> create(writer: ModuleWriter<T>) = writer.visit(gitIgnore = this)
}