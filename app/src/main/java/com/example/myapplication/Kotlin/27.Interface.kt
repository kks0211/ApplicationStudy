package com.example.myapplication.Kotlin

fun main() {
    val student_: Student_ = Student_()
    student_.eat()
    student_.sleep()

}

//생성자가 없다 - > 인스턴스화 시킬수 없다.
interface Persion_ {
    fun eat()
    fun sleep() {
        println("잔다")
    }

    abstract fun study()
}

class Student_ : Persion_ {
    override fun eat() {
        println("먹다")
    }

    override fun study() {
    }
}

class SoccerPlay : Persion_ {
    override fun eat() {

    }

    override fun sleep() {
    }

    override fun study() {
    }
}


open class Person() {
    open fun eat() {

    }

    fun sleep() {

    }
}

class Student() : Person() {
    override fun eat() {
        super.eat()
    }

}

class Teacher() : Person() {

}