package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("one"))
        tab_layout.addTab(tab_layout.newTab().setText("two"))
        tab_layout.addTab(tab_layout.newTab().setText("three"))


        val adapter = ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                //탭을 클릭했을때 이동
                view_pager.currentItem = tab!!.position
            }
        })
    }
}

class ThreePageAdapter(val layoutInflater: LayoutInflater): PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //실제적으로 뷰를 그려주는 부분
        when(position){
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
            1 ->{
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }
            2 ->{
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view
            }
            else ->{
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //view가 가려질 때 파기
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        //view 확인
        return view === `object` as View
    }

    override fun getCount(): Int {
        return 3
    }
}
