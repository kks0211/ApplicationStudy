package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener{
            //val intent = Intent(this, Intent2::class.java)
            //명시적 인텐트
            /*val intent = Intent(this@Intent1, Intent2::class.java)
            intent.putExtra("number1",1)
            intent.putExtra("number2",2)
            startActivity(intent)*/

            /*val intent2 = Intent(this@Intent1, Intent2::class.java)
            // Apply ->
            intent2.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            //startActivity(intent2)

            startActivityForResult(intent2, 200 )   //결과 받을때*/

            //암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"))
            startActivity(intent)


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200) {
            Log.d("number", "" + resultCode)
            Log.d("number", "" + requestCode)

            val result = data?.getIntExtra("result", 0)
            Log.d("number", ""+result)

        }
    }
}
