package com.hong.myfirstkotlinproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hong.myfirstkotlinproject.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private val contentModels = mutableListOf<ContentsModel>()

    private lateinit var auth : FirebaseAuth

    private lateinit var binding: FragmentInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        val database = Firebase.database
        val myBookmark = database.getReference("bookmark_ref")

        val rv = binding.recyclerView

        val rvAdapter = RVAdapter(requireContext() ,contentModels)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        myBookmark.child(auth.currentUser?.uid.toString()).addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataModel in snapshot.children) {
                        contentModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }

                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("Bookmark", "DB error")
                }

            }
        )

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(requireContext(), ViewActivity::class.java)
                intent.putExtra("url", contentModels[position].url)
                intent.putExtra("title", contentModels[position].titleText)
                intent.putExtra("imageUrl", contentModels[position].imageUrl)
                startActivity(intent)
            }
        }

        binding.tabBtn1.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoFragment_to_foodFragment)
        }

        binding.tabBtn2.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoFragment_to_diceFragment)

        }

        binding.tabBtn3.setOnClickListener {
            it.findNavController().navigate(R.id.action_infoFragment_to_memoFragment)
        }

        binding.tabBtn4.setOnClickListener {

        }


        return binding.root
    }

}