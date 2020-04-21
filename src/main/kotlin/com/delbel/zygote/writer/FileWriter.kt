package com.delbel.zygote.writer

import java.io.File

class FileWriter(root: File) : Writer<File>(root) {

    override fun addContainer(name: String) {
        File(root, name).mkdir()
    }

    override fun create(): File = root
}