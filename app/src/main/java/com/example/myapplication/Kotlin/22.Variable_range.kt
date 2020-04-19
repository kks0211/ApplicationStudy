package com.example.myapplication.Kotlin


fun main() {

    val test = Test("홍길동")
    test.test()
    test.name
    println(test.name)

}


class Test(var name:String){
    fun test(){
        name = "홍길동1"
    }
}