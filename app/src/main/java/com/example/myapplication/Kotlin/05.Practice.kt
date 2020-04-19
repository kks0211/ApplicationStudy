package com.example.myapplication.Kotlin


fun plusThree(first: Int, second: Int, third: Int): Int {
    return first + second + third
}

fun minusThree(first: Int, second: Int, third: Int): Int {
    return first - second - third
}

fun main() {
    var t = plusThree(100, 20, 30)
    println(t)
    var t1 = minusThree(100, 20, 30)
    println(t1)
    showMyPlus(100,200)
}

fun showMyPlus(first: Int, second: Int): Int {
    println(first)
    println(second)

    //return first + second
    fun plus(first: Int, second: Int): Int{
        return first + second
    }

    println("-----" + plus(first,second))
    return plus(first, second)

}