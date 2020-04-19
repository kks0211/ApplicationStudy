package com.example.myapplication.Kotlin

fun main() {
    val one: Int = 1
    val two: Int = 2
    val three: Int = 3
    val four: Int = 4
    val five: Int = 5
    val six: Int = 6

    var group1 = arrayOf<Int>(1,2,3,4,5)

    println(group1 is Array)
    println(group1.size)
    println(group1.get(1))

    var group2 = arrayOf(1,"2","3")
    println(group2.get(2))
    println("===> " + group2[1])

    group2.set(2, "4")
    group2[0] = 3
    println("==2>" + group2[2] )
    println("==3>" + group2[0] )


}