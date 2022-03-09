package com.hong.splashalbumpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")

        Toast.makeText(this, getData, Toast.LENGTH_SHORT).show()

        val imgView = findViewById<ImageView>(R.id.clickImage)

        when (getData) {
            "1" -> {
                imgView.setImageResource(R.drawable.img1)
            }
            "2" -> {
                imgView.setImageResource(R.drawable.img2)
            }
            "3" -> {
                imgView.setImageResource(R.drawable.img3)
            }
            "4" -> {
                imgView.setImageResource(R.drawable.img4)
            }
            "5" -> {
                imgView.setImageResource(R.drawable.img5)
            }
            "6" -> {
                imgView.setImageResource(R.drawable.img6)
            }
        }




    }
}