package com.hong.albumpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. 프로그램이 화면이 출력되었다는 것을 알아야함
        val image1 = findViewById<ImageView>(R.id.img1)
        image1.setOnClickListener {
            Toast.makeText(this, "1번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity1::class.java)
            startActivity(intent)
        }

        //나머지 img들의 이름을 다 붙이고, 가각 클릭 시, 다른 액티비티로 이동!
        val image2 = findViewById<ImageView>(R.id.img2)
        image2.setOnClickListener {
            Toast.makeText(this, "2번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity2::class.java)
            startActivity(intent)
        }
        val image3 = findViewById<ImageView>(R.id.img3)
        image3.setOnClickListener {
            Toast.makeText(this, "3번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity3::class.java)
            startActivity(intent)
        }
        val image4 = findViewById<ImageView>(R.id.img4)
        image4.setOnClickListener {
            Toast.makeText(this, "4번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity4::class.java)
            startActivity(intent)
        }
        val image5 = findViewById<ImageView>(R.id.img5)
        image5.setOnClickListener {
            Toast.makeText(this, "5번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity5::class.java)
            startActivity(intent)
        }
        val image6 = findViewById<ImageView>(R.id.img6)
        image6.setOnClickListener {
            Toast.makeText(this, "6번 클릭 완료", Toast.LENGTH_LONG).show()
            //2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줘야함
            val intent = Intent(this, ImgActivity6::class.java)
            startActivity(intent)
        }

    }
}