package com.hong.myfirstkotlinproject

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hong.myfirstkotlinproject.databinding.FragmentFoodBinding
import com.hong.myfirstkotlinproject.databinding.FragmentMemoBinding
import java.util.*

class MemoFragment : Fragment() {

    val dataModelList = mutableListOf<DataModel>()

    private lateinit var binding : FragmentMemoBinding

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMemoBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        val database = Firebase.database
        val myMemo = database.getReference("memo_ref").child(Firebase.auth.currentUser!!.uid)

        val listView = binding.listView

        val adapter = LVAdapter(dataModelList)

        listView.adapter=adapter

        myMemo.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()

                for (dataModel in snapshot.children) {
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        binding.writeBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(requireContext())
                .setView(mDialogView)
                .setTitle("메모")
            val mAlertDialog = mBuilder.show()
            val dateSelectBtn = mAlertDialog.findViewById<Button>(R.id.calBtn)

            var dataText = " "

            dateSelectBtn?.setOnClickListener {

                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)
                val dlg =
                    DatePickerDialog(requireContext(), object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                            dataText = "${p1}/ ${p2 + 1}/ ${p3}"
                            dateSelectBtn.setText(dataText)
                        }
                    }, year, month, date)

                dlg.show()
            }

            mAlertDialog.findViewById<Button>(R.id.saveBtn)?.setOnClickListener {
                val memo = mAlertDialog.findViewById<EditText>(R.id.memo)?.text.toString()
                val model = DataModel(dataText, memo)
                myMemo.push().setValue(model)
                mAlertDialog.dismiss()
            }

        }

        binding.tabBtn1.setOnClickListener {
            it.findNavController().navigate(R.id.action_memoFragment_to_foodFragment)
        }

        binding.tabBtn2.setOnClickListener {
            it.findNavController().navigate(R.id.action_memoFragment_to_diceFragment)

        }

        binding.tabBtn3.setOnClickListener {

        }

        binding.tabBtn4.setOnClickListener {
            it.findNavController().navigate(R.id.action_memoFragment_to_infoFragment)
        }

        return binding.root
    }


}