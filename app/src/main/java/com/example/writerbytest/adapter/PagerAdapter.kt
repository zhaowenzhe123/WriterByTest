package com.example.writerbytest.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragment:Fragment, val datas:ArrayList<Fragment>) :FragmentStateAdapter(fragment){


    // 添加 Fragment 到列表中
    //估计顺序问题 不知道为什么暂时没有成功
    fun addFragment(fragment: Fragment) {
        datas.add(fragment)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun createFragment(position: Int): Fragment {
        return datas[position]
    }


}