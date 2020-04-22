package com.delbel.zygote.feature.module.gradle

import com.delbel.zygote.writer.ModuleWriteable

interface BuildGradle : ModuleWriteable {

    fun relativePath(): String
}