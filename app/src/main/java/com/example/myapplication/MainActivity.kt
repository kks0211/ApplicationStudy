package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.practice_15)
        Log.d("life_cylcle", "onCreate")
    }

    override fun onStart() {
        Log.d("life_cylcle", "onStart")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cylcle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cylcle", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cylcle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cylcle", "onDestroy")
    }
}
