package com.hong.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.hong.diceapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val diceImg1 = binding.dice1
        val diceImg2 = binding.dice2

        binding.diceStartBtn.setOnClickListener {

            val num1 = Random.nextInt(1, 6)
            val num2 = Random.nextInt(1, 6)

            when(num1){
                1 -> diceImg1.setImageResource(R.drawable.dice_1)
                2 -> diceImg1.setImageResource(R.drawable.dice_2)
                3 -> diceImg1.setImageResource(R.drawable.dice_3)
                4 -> diceImg1.setImageResource(R.drawable.dice_4)
                5 -> diceImg1.setImageResource(R.drawable.dice_5)
                6 -> diceImg1.setImageResource(R.drawable.dice_6)
            }

            when(num2){
                1 -> diceImg2.setImageResource(R.drawable.dice_1)
                2 -> diceImg2.setImageResource(R.drawable.dice_2)
                3 -> diceImg2.setImageResource(R.drawable.dice_3)
                4 -> diceImg2.setImageResource(R.drawable.dice_4)
                5 -> diceImg2.setImageResource(R.drawable.dice_5)
                6 -> diceImg2.setImageResource(R.drawable.dice_6)
            }

            Toast.makeText(this, "결과는 " + (num1 + num2).toString() + "입니다", Toast.LENGTH_SHORT)
                .show()

        }

    }
}