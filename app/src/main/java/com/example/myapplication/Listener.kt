package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        //뷰를 activity로 가져오는 방법
        //1. 직접찾음
        //val textView : TextView = findViewById(R.id.hello)

        //2. xml을 import해서 가져옴 (람다식)
        // 표현1
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        }

        //표현 2 (익명함수 방식)
        hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("test", "testClick!1")
            }
        })
        //표현 3
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                var num = 10
                //Log.d("test", "testClick!2")
                //뷰를 조작하는 함수
                hello.setText("안녕하세요.")
                image.setImageResource(R.drawable.man)
                num += 10
                Log.d("test", "testClick!2")
                Log.d("num",""+num)

            }
        }
        hello.setOnClickListener(click)

        hello.setOnClickListener {
            Log.d("Test : " , "Click!!")

        }



    }
}
