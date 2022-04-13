package com.ebookfrenzy.carddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.carddemo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?:return
        val qString = extras.getString("qString")
        val qString1 = extras.getString("qString1")
        val qString2 = extras.getInt("qString2")
        binding.aItemTitle.text = qString
        binding.aItemDetail.text = qString1
        binding.aItemImage.setImageResource(qString2)
        //binding.aItemImage = qString2
        /*if (qString2 != null) {
            binding.aItemImage.setImageResource(qString2.toInt())
        }*/
    }

}