package com.delbel.zygote.module.content.hard

import com.delbel.zygote.module.Module

class GitIgnoreFile : HardContent() {

    override val name: String = ".gitignore"

    override val source: String = "/hard/.gitignore"

    override fun pathIn(module: Module) = module.relativePathFor(file = this)
}