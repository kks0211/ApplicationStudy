package com.example.myapplication.Kotlin

//Generic
//목적 : 다양항 타입의 객체들을 다루는 메소드나 컬렉션
//      클래스에서 컴파일 시에 타입을 체크해주는 기능 ex) <String>


fun main() {
    val list1 = listOf<Int>(1, 2, 3)

    val list2 = listOf(1, 2, 3, "test")
    val b: String = list2[2].toString()  //형변환

    val list3 = listOf<String>("a", "b", "c")
    val c: String = list3[0]

    //강한 타입을 체크 할수 있다.
    val list5 = listOf("a", "b", "c", 1, 2, 3) //특이

    //제너릭을 사용하지 않는 경우
    val list6 = listOf<Any>(1,2,3,"가")
    //Any 부모
    //String, Int, Float 자식

}