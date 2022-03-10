package com.hong.val_log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var: 값 변경 가능
        //val: 값 변경 불가
        var value = "여기는 value입니다!"
        val value2 = "여기는 value2립니다!"

        value = "value값을 한 번 변경하였습니다."

        //log
        Log.d("MainActivity", "testLog")
        val test = "여기는 test값 입니다."
        Log.d("MainActivity", test)

        //log 종류
        Log.e("MainActivity", "오류") //오류
        Log.w("MainActivity", "경고") //경고
        Log.i("MainActivity", "정보") //정보
        Log.d("MainActivity", "디버그" ) //디버그
        Log.v("MainActivity", "상세") //상세


    }
}