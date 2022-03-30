package com.hong.myfirstkotlinproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hong.myfirstkotlinproject.databinding.FragmentDiceBinding
import com.hong.myfirstkotlinproject.databinding.FragmentFoodBinding

class FoodFragment : Fragment() {

    private lateinit var binding : FragmentFoodBinding

    private val items =  mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFoodBinding.inflate(inflater, container, false)

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/vhEkq5EYh0r4",
                "https://mp-seoul-image-production-s3.mangoplate.com/46651_1630510033594478.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "구움양과 by 런던케이크"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/Tcbx1WNZ-rgK",
                "https://mp-seoul-image-production-s3.mangoplate.com/801050_1606833865909871.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "헤이스윗"
            )
        )

        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/E_sacq_fLAj0",
                "https://mp-seoul-image-production-s3.mangoplate.com/616631_1648254737545118.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "열매제과점"
            )
        )


        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/SyqlfkKhlAD0",
                "https://mp-seoul-image-production-s3.mangoplate.com/339003/1199904_1605755418701_38996?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "리틀빅토리"
            )
        )


        items.add(
            ContentsModel(
                "https://www.mangoplate.com/restaurants/n3yDXbvBOw",
                "https://mp-seoul-image-production-s3.mangoplate.com/1269552_1590498906017352.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "디어브레드"
            )
        )

        val rv = binding.recyclerView
        val rvAdapter = RVAdapter(requireContext() ,items)
        rv.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireContext(), ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].imageUrl)
                startActivity(intent)
            }
        }

        rv.layoutManager = GridLayoutManager(requireContext(), 2)



        binding.tabBtn1.setOnClickListener {

        }

        binding.tabBtn2.setOnClickListener {
            it.findNavController().navigate(R.id.action_foodFragment_to_diceFragment)

        }

        binding.tabBtn3.setOnClickListener {
            it.findNavController().navigate(R.id.action_foodFragment_to_memoFragment)
        }

        binding.tabBtn4.setOnClickListener {
            it.findNavController().navigate(R.id.action_foodFragment_to_infoFragment)
        }

        return binding.root
    }
}