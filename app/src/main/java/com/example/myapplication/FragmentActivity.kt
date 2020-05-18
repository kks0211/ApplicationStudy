package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass", "$data")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cylcle", "onCreate")

        val fragmentOne: FragmentOne = FragmentOne()
        // fragment에 데이터를 넣어주는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        button.setOnClickListener {
            //fragment 동적으로 작동 하는 방법
            val fragmentManager: FragmentManager = supportFragmentManager

            //Transation
            //작업의 단위
            val fragmentTransaction = fragmentManager.beginTransaction()
            // replace / add
            fragmentTransaction.replace(R.id.container, fragmentOne)
            //끝을 내는 방법
            //commit    -> 천천히
            //commitnow -> 지금 당장
            fragmentTransaction.commit()

        }

        button2.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            // fragment remove / detach
            //fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()

        }

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
