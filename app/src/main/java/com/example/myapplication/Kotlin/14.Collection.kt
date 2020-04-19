package com.example.myapplication.Kotlin


fun main() {
    //중복허용
    //내용 변경 불가 value
    val numberList = listOf<Int>(1,2,3,3)
    println(numberList)
    println(numberList.get(0))
    println(numberList[1])


    //중복 허용안홤
    //순서없다
    val numberSet = setOf<Int>(1,2,3,3)
    println(numberSet)
    numberSet.forEach{
        println(it)
    }

    val numberMap = mapOf<String,Int>("one" to 1, "two" to 2)
    println(numberMap)
    println(numberMap.get("one"))

    //변경 가능 리스트
    val mNumberList = mutableListOf<Int>(1,2,3)
    mNumberList.add(3,4)
    println(mNumberList)

    val mNumberSet = mutableSetOf<Int>(1,2,3,3)
    mNumberSet.add(10)
    println(mNumberSet)

    val mNumberMap = mutableMapOf<String, Int>("one" to 1)
    mNumberMap.put("two", 2)
    println(mNumberMap)

}