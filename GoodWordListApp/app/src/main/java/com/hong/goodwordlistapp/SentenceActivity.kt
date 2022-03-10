package com.hong.goodwordlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.hong.goodwordlistapp.databinding.ActivityMainBinding

class SentenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("우리는 서로의 입장과 처지를 바꿔 생각해야 한다.")
        sentenceList.add("싫어하는 사람을 상대하는 것도 하나의 지혜이다.")
        sentenceList.add("신용을 잃어버린 자는 설 땅이 없게 된다.")
        sentenceList.add("자기가 싫어하는 것을 남에게 베풀지 말아라.")
        sentenceList.add("정의가 없는 용기는 나약하기 짝이 없다.")
        sentenceList.add("침묵은 진정한 지혜에서 나오는 최고의 답이다.")
        sentenceList.add("어느 정도 깊이 괴로워하느냐 하는 것이 인간의 위치를 결정한다.")

        val sentenceAdapter = ListViewAdapter(sentenceList)
        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = sentenceAdapter

    }
}