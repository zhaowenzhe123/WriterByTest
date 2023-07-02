package com.example.writerbytest.writer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.writerbytest.PeletteActivity
import com.example.writerbytest.WriterActivity
import com.example.writerbytest.adapter.PagerAdapter
import com.example.writerbytest.databinding.FragmentC1Binding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/*
随手记container1
 */
class C1Fragment : Fragment() {
    private val fragmentList = arrayListOf<Fragment>()
    private val tabTitleList = arrayOf("全部","工作","生活")

    private lateinit var binding: FragmentC1Binding
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var button: FloatingActionButton
    private lateinit var buttonP: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =FragmentC1Binding.inflate(layoutInflater)
        viewPager2 = binding.viewPager2
        tabLayout = binding.tabLayout
        //设置点击按钮添加事件
        button = binding.button
        buttonP= binding.buttonP
        button.setOnClickListener{
            val intent = Intent(this@C1Fragment.context,WriterActivity::class.java)
            startActivity(intent)
        }
        buttonP.setOnClickListener{
            val intent = Intent(this@C1Fragment.context,PeletteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //添加fragment到viewpager
        for (i in tabTitleList)
        {
            fragmentList.add(AllFragment())
        }
        val fragmentAdapter= PagerAdapter(this,fragmentList)
      //  fragmentAdapter.addFragment(fragment =AllFragment())
        binding.viewPager2.adapter = fragmentAdapter
      //  tabLayout.tabMode = TabLayout.MODE_FIXED
        TabLayoutMediator(tabLayout,viewPager2){tab,position ->
            tab.text = tabTitleList[position]
        }.attach()
    }


}