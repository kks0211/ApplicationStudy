package com.example.myapplication.Kotlin

fun test(first: Int, second: Int): Int {
    val result = first + second
    return result

}

// 디폴트 값
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

fun plusFive2(first: Int, second: Int) = first + second

// Unit 생략가능
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    println(result)
}

//가변 값
fun plusMany(vararg numbers:Int){
    for(number in numbers){
        println(number)
    }
}


fun main() {
    println(test(5, 2))
    val result = plusFive(3, 1)
    println(result)
    printPlus(3, 2)
    val result1 = plusFive2(10, 20)
    println(result1)

    plusMany(1,2,3,4,5)
}