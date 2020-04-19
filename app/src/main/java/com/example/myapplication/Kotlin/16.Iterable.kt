package com.example.myapplication.Kotlin

fun main() {
    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    for (item in a) {
        //println(item)
    }
    println()
    for ((index, item) in a.withIndex()) {
        println("" + index + " : " + item)
    }
    println()
    //람다식
    a.forEach() {
        println("=>" + it)
    }
    println()
    a.forEach() { item ->
        println("1=>" + item)
    }
    println()
    a.forEachIndexed { index, i ->
        println("" + index + " : " + i)
    }
    println()
    for (i in 0 until a.size) {
        println(a.get(i))
    }
    println()
    for (i in 0 until a.size step (2)) {
        //1,3,5,7
        println(a.get(i))
    }
    println()
    for (i in a.size - 1 downTo (0)) {
        //8~0까지 반복
        println(a.get(i))
    }
    println()
    for (i in a.size - 1 downTo (0) step (2)) {
        //8~0까지 반복
        println(a.get(i))
    }
    println()
    for (i in 0..10) {
        //0~10까지
        println(i)
    }
    println()
    var b = 5
    var c = 4
    while (b < c) {
        b++
        println(b)
    }
    println()
    do {
        println(b)
    } while (b < c)


}
