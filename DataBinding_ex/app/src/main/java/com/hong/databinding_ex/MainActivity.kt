package com.hong.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hong.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        //1번 방식 - findViewById
//        val btn = findViewById<Button>(R.id.testBtn)
//        btn.setOnClickListener{
//            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
//        }

        //2번 방식 - Databinding
        //코드가 더 단순해짐!
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.testBtn.setOnClickListener {
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show()
        }




    }
}