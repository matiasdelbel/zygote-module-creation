package com.delbel.zygote.writer

import java.lang.StringBuilder

class StringWriter(root: String) : Writer<String>(root) {

    private val featureBuilder = StringBuilder().apply { append(root) }

    override fun addContainer(name: String) {
        featureBuilder.append("$name/")
    }

    override fun create(): String = featureBuilder.toString()
}