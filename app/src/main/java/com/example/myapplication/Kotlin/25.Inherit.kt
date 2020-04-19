package com.example.myapplication.Kotlin

fun main() {
    val supercar: SuperCarr = SuperCarr()
    supercar.drive()
    supercar.stop()
}

open class Carr() {
    open fun drive(): String {
        //println("달린다")
        return "달린다"

    }

    fun stop() {

    }
}

class SuperCarr() : Carr() {
    override fun drive(): String {
        //println("빨리 달린다")
        val run = super.drive()
        println("1빨리 $run")
        return "빨리 $run"
    }
}

class Bus() : Carr() {

}