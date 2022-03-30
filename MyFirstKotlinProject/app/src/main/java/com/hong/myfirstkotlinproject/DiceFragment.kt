package com.hong.myfirstkotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.hong.myfirstkotlinproject.databinding.FragmentDiceBinding
import kotlin.random.Random

class DiceFragment : Fragment() {

    private lateinit var binding : FragmentDiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDiceBinding.inflate(inflater, container, false)

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

            Toast.makeText(context, "결과는 " + (num1 + num2).toString() + "입니다", Toast.LENGTH_SHORT)
                .show()
        }

        binding.tabBtn1.setOnClickListener {
            it.findNavController().navigate(R.id.action_diceFragment_to_foodFragment)
        }

        binding.tabBtn2.setOnClickListener {

        }

        binding.tabBtn3.setOnClickListener {
            it.findNavController().navigate(R.id.action_diceFragment_to_memoFragment)
        }

        binding.tabBtn4.setOnClickListener {
            it.findNavController().navigate(R.id.action_diceFragment_to_infoFragment)
        }

        return binding.root

    }

}