package com.delbel.zygote.writer

/*
class StringModuleWriter(parent: String) : ModuleWriter<String>(parent, "") {

    private val featureBuilder = StringBuilder()

    override fun visit(sourceMain: MainSource) {
        featureBuilder.appendln()
        var sourcePath = sourceMain.sourcePath()
        //sourceMain.packages().forEach { sourcePath = "$sourcePath/$it" }
        //featureBuilder.append("${moduleContainer}/$sourcePath")
    }

    override fun visit(sourceTest: TestSource) {
        featureBuilder.appendln()
        var sourcePath = sourceTest.sourcePath()
        //sourceTest.packages().forEach { sourcePath = "$sourcePath/$it" }
        featureBuilder.append("${moduleContainer}/$sourcePath")

        featureBuilder.appendln()
        //featureBuilder.append("${moduleContainer}/${sourceTest.mockMarkerPath()}")
    }

    fun test(): String = featureBuilder.toString()
}*/