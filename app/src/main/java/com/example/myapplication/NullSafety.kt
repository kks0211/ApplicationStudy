package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class NullSafety : AppCompatActivity() {

    lateinit var lateCar: Car

    class Car(var number:Int){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safety_null)

        val number1 :Int = 10
        val number2: Int? = null

        val number3 = number2?.plus(number1)    //number2가 null 이면 뒤에를 실행 안함
        Log.d("number", "number3 : $number3")

        //삼항 연산자 -> 엘비스 연산자
        // null Safety를 위한 도구
        val number4 = number2?:10   //number2이 null이면 10
        Log.d("number", "number4 : $number4")

        lateCar = Car(10)
        Log.d("number", "late number : ${lateCar.number}")
    }

    fun plus (a: Int, b:Int?): Int{
        if (b!=null)
            return a+b
        else {
            return a
        }
    }


}
