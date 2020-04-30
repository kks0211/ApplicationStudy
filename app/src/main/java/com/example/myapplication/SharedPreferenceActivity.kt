package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        //Mode
        // - MODE_PRIVATE 생성한 Application에서만 사용 가능
        // - MODE_WORLD_READABLE 다른 Application에서도 사용 가능 (읽기만)
        // - MODE_WORLD_WRITEABLE 다른 Application에서도 사용 가능
        // - MODE_MULTI_PROCESS 이미 호출되어 사용 중인지 체크
        // - MODE_APPEND 기존 preference에 신규로 추가

        save_btn.setOnClickListener {
            //SharedPreference
            val sharedPerference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPerference.edit()
            editor.putString("hello", "안녕하세요" )
            editor.putString("bye", "잘가" )
            editor.commit()
        }

        load_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "NULL DATA1")
            val value2 = sharedPreference.getString("bye", "NULL DATA2")
            Log.d("key-value", "Value1 : $value1")
            Log.d("key-value", "Value2 : $value2")
        }

        delete_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editoer = sharedPreference.edit()
            editoer.remove("hello")
            editoer.commit()
        }

        deleteall_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editoer = sharedPreference.edit()
            editoer.clear()
            editoer.commit()
        }

    }
}
