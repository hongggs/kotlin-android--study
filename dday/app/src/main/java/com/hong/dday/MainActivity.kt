package com.hong.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val endBtn = findViewById<Button>(R.id.endBtn)
        val dateText = findViewById<TextView>(R.id.dayText)

        val calendarStart = Calendar.getInstance()
        val calendarEnd = Calendar.getInstance()

        startBtn.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

                    calendarStart.apply {
                        set(Calendar.YEAR, p1)
                        set(Calendar.MONTH, p2+1)
                        set(Calendar.DAY_OF_MONTH, p3)
                    }.timeInMillis

                    Log.d("main",calendarStart.toString())

                }
            }, year, month, date)

            dlg.show()
        }

        endBtn.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val date = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

                    calendarEnd.apply {
                        set(Calendar.YEAR, p1)
                        set(Calendar.MONTH, p2+1)
                        set(Calendar.DAY_OF_MONTH, p3)
                    }.timeInMillis

                    val finalDate = (calendarEnd.timeInMillis - calendarStart.timeInMillis) / (24 * 60 * 60 * 1000) +1

                    dateText.text = (finalDate.toString())
                }
            }, year, month, date)

            dlg.show()

        }


    }
}