 package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_view.*
import java.util.*

 class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        //item list
        for(i in 0 until 30){
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }
        val adapter = ListViewAdapter(carList, this@ListViewActivity)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this@ListViewActivity, "$carName $carEngine", Toast.LENGTH_SHORT).show()

        }
    }
}

 class ListViewAdapter(val carForList : ArrayList<CarForList>
                       , val context : Context) : BaseAdapter(){

     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
         val layoutInflater = LayoutInflater.from(context)
         /*  val view = layoutInflater.inflate(R.layout.item_view, null)
           val carNameTextView = view.findViewById<TextView>(R.id.car_name)
           val carEngineTextView = view.findViewById<TextView>(R.id.car_engine)

           carNameTextView.setText(carForList.get(position).name)
           carEngineTextView.setText(carForList.get(position).engine)

           return view*/

         val view: View
         val holder: ViewHolder

         if(convertView == null){
             Log.d("convert", "1")
             view = layoutInflater.inflate(R.layout.item_view, null)
             holder = ViewHolder()
             
             holder.carName = view.findViewById(R.id.car_name)
             holder.carEngine = view.findViewById(R.id.car_engine)

             view.tag = holder
         } else {
             Log.d("convert", "2")
             holder = convertView.tag as ViewHolder
             view = convertView
         }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

         return view
     }

     override fun getItem(position: Int): Any {
         //그리고자 하는 아이템 리스트 하나 (position에 해당)
         return carForList.get(position)
     }

     override fun getItemId(position: Int): Long {
         // 해당 position에 위치해 있는 아이템 뷰의 아이디 설정
         return position.toLong()
     }

     override fun getCount(): Int {
         //그리고자 하는 아이템 리스트의 전체 갯수
         return carForList.size
     }
 }

 //요즘 리스트 뷰 만들때 권장
 class ViewHolder{
     var carEngine: TextView? = null
     var carName: TextView? = null
 }