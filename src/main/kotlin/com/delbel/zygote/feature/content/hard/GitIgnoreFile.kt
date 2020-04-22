package com.delbel.zygote.feature.content.hard

import com.delbel.zygote.feature.Module

class GitIgnoreFile : HardContent() {

    override val name: String = ".gitignore"

    override val source: String = "/hard/.gitignore"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)
}