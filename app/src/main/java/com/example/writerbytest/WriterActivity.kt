package com.example.writerbytest


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import android.view.LayoutInflater

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.writerbytest.databinding.ActivityWriterBinding

class WriterActivity : ComponentActivity() {
    private lateinit var binding: ActivityWriterBinding
    private lateinit var saveButton: Button
    private lateinit var ettitle: EditText
    private lateinit var etcontent: EditText

    var ID: Int = -1
    var ischange = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityWriterBinding.inflate(LayoutInflater.from(this))
        ettitle = binding.ettitle
        etcontent = binding.etcontent
        saveButton = binding.saveButton
        setContentView(binding.root)

        title = ""

        ID = intent.getIntExtra("ID", -1)
        if (ID >= 0) {
//            var bean = nm.queryNote(ID)
//
//            etcontent.setText(bean.content)
//            ettitle.setText(bean.title)
        }

        saveButton.setOnClickListener{
                if (ettitle.text.length < 0){
                    Toast.makeText(this@WriterActivity,"标题不能为空",Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            if (etcontent.text.length< 0){
                Toast.makeText(this@WriterActivity,"内容不能为空",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
//            save()
            finish()
        }

        ettitle.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                ischange = true //将笔记改变状态设置成true
            }
        })
        //监听内容改变事件
        etcontent.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                ischange = true //将笔记改变状态设置成true
            }

        })
    }

//    private fun save() {
//        if (ID >= 0) {//修改
//            nm.changeNote(ID, etcontent.text.toString(),ettitle.text.toString())//修改这条笔记
//            Toast.makeText(this@WriterActivity, "修改成功", Toast.LENGTH_LONG).show()
//        } else {//新增
//            nm.addNote(etcontent.text.toString(),ettitle.text.toString(), )//数据库新增一条笔记
//            Toast.makeText(this@WriterActivity, "保存成功", Toast.LENGTH_LONG).show()
//        }
//    }
}






