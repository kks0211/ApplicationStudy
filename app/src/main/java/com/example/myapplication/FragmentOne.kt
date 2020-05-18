package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {

    lateinit var dataPasseListener: OnDataPassListener

    interface OnDataPassListener {
        fun onDataPass(data: String?)
    }

    override fun onAttach(context: Context) {
        Log.d("life_cylcle", "F onAttach")
        super.onAttach(context)
        dataPasseListener = context as OnDataPassListener // 형변환
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cylcle", "F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cylcle", "F onCreateView")

        // fragment 가 인터페이스를 처음으로 그릴 때 호출 됨
        // inflater 뷰를 그려준
        // container -> 부모 뷰

        return inflater.inflate(R.layout.fragment_one, container, false)
        //return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cylcle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        //Activity의 Oncreate에서 했던 작업을 여기에서 함
        pass.setOnClickListener {
            dataPasseListener.onDataPass("Good Bye~")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cylcle", "F onActivityCreated")

        val data = arguments?.getString("hello")
        Log.d("data", data)

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cylcle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cylcle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cylcle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cylcle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cylcle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cylcle", "F onDetach")
        super.onDetach()
    }
}