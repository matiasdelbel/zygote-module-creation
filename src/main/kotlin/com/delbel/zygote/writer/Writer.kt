package com.delbel.zygote.writer

abstract class Writer<T>(protected val root: T) {

    abstract fun addContainer(name: String)

    abstract fun create(): T
}