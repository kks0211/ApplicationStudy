package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val runable: Runnable = object : Runnable{
            override fun run() {
                Log.d("thrad-1", "thread is made")
            }
        }

        val thread : Thread = Thread(runable)

        button.setOnClickListener {
            thread.start()
        }

        Thread(object: Runnable{
            override fun run() {
                Log.d("thrad-2", "thread is made")
            }
        }).start()

        Thread(Runnable{
            Log.d("thrad-3", "thread is made")
            Thread.sleep(2000)
            //button.setBackgroundColor(getColor(R.color.textview_color)) // 메인 쓰레드만 접근 가능
            runOnUiThread{
                button.setBackgroundColor(getColor(R.color.textview_color)) // 메인 쓰레드만 접근 가능
            }

        }).start()




    }
}
