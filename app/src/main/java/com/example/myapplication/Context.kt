package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Context : AppCompatActivity() {   //Context API 를 상속함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context: Context = this
        val applicationContext: Context = getApplicationContext() as Context

    }
}
