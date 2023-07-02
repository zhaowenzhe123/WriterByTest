package com.example.writerbytest

import android.os.Bundle
import android.widget.AbsSeekBar
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.writerbytest.databinding.ActivityPeletterBinding



class PeletteActivity : ComponentActivity() {
    private lateinit var binding: ActivityPeletterBinding
    private lateinit var textView: TextView
    private lateinit var buttonLeft :Button
    private lateinit var buttonRight:Button
    private lateinit var switch1:Switch
    private lateinit var progressBar:ProgressBar
    private lateinit var buttonSure:Button
    private lateinit var editText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var imageView: ImageView
    private lateinit var seekBar: AbsSeekBar
    private lateinit var checkBox: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var ratingBar: RatingBar
    var yuwen =""
    var shuxue =""
    var yingyu = ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPeletterBinding.inflate(layoutInflater)
        textView = binding.textView
        buttonLeft = binding.buttonLeft
        buttonRight = binding.buttonRight
        switch1 = binding.switch1
        progressBar = binding.progressBar
        buttonSure = binding.buttonSure
        editText = binding.editTextNumber
        radioGroup = binding.group
        imageView = binding.imageView2
        seekBar = binding.seekBar
        checkBox = binding.checkBox
        checkBox2 = binding.checkBox2
        checkBox3 = binding.checkBox3
        ratingBar = binding.ratingBar
        setContentView(binding.root)

        buttonLeft.setOnClickListener {
            textView.setText("左")
        }
        buttonRight.setOnClickListener {
            textView.setText("右")
        }

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textView.setText("开")
            } else {
                textView.setText("关")
            }

        }
        buttonSure.setOnClickListener {
            var s = editText.text.toString()
            if (s.isEmpty()) {
                s = "0"
            }
            progressBar.setProgress(Integer.valueOf(s))
        }

        radioGroup.setOnCheckedChangeListener { group, checkId ->
            if (checkId == R.id.radioButton3) {
                imageView.setImageResource(R.drawable.tab)
            } else {
                imageView.setImageResource(R.drawable.write)
            }

        }

        (seekBar as SeekBar).setOnSeekBarChangeListener(object: OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView.setText("$progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })

        checkBox.setOnCheckedChangeListener{ buttonView , isCheck ->
            if (isCheck){
                yuwen = "语文"
            }else{
                yuwen = ""
            }
            textView.setText(yuwen+shuxue+yingyu)
        }
        checkBox2.setOnCheckedChangeListener{ buttonView , isCheck ->
            if (isCheck){
                shuxue = "数学"
            }else{
                shuxue = ""
            }
            textView.setText(yuwen+shuxue+yingyu)

        }
        checkBox3.setOnCheckedChangeListener{ buttonView , isCheck ->
            if (isCheck){
                yingyu = "英语"
            }else{
                yingyu = ""
            }
            textView.setText(yuwen+shuxue+yingyu)

        }

        ratingBar.setOnRatingBarChangeListener{ratingBar,rating ,fromUser ->
            Toast.makeText(this,"您的评分为 $rating",Toast.LENGTH_LONG).show()
        }
    }

}
