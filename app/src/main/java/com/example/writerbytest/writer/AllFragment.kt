package com.example.writerbytest.writer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.writerbytest.NoteAdapter
import com.example.writerbytest.NoteApplication
import com.example.writerbytest.databinding.FragmentAllBinding
import com.example.writerbytest.viewmodels.NoteViewModel
import com.example.writerbytest.viewmodels.NoteViewModelFactory


class AllFragment() : Fragment() {

    private lateinit var binding: FragmentAllBinding
    private val viewModel :NoteViewModel by activityViewModels {
        NoteViewModelFactory(
            (activity?.application as NoteApplication).database.noteDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAllBinding.inflate(LayoutInflater.from(activity))
        //requireContext会返回当前fragment所附属的context
        //初始化笔记管理器


        //       val layoutManager = LinearLayoutManager(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvAll.apply {

            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            (layoutManager as StaggeredGridLayoutManager).orientation =LinearLayoutManager.VERTICAL
        }
        //改导航了



        }


    }

    // 在onStart中设置适配器 每次显示MainActivity都会更新一下数据





