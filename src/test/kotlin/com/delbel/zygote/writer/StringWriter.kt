package com.delbel.zygote.writer

/*
class StringWriter(root: String) : Writer<String>(root, "", root= "") {

    private val featureBuilder = StringBuilder().apply { append(root) }
    private lateinit var moduleWriter: StringModuleWriter

    override fun visit(feature: Feature) {
        //featureBuilder.append(feature.name)
    }

    /*override fun visit(module: Module): StringModuleWriter {
        //val absolutePath = "${root}${module.path()}"

        featureBuilder.appendln()
        featureBuilder.appendln()
        //featureBuilder.append(absolutePath)

        //moduleWriter = StringModuleWriter(parent = absolutePath)

        return moduleWriter
    }*/

    fun test(): String {
        if (::moduleWriter.isInitialized)
            featureBuilder.append(moduleWriter.test())

        return featureBuilder.toString()
    }

    override fun visit(module: Module): Pair<ModuleWriter<String>, ContentWriter> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}*/