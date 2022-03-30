package com.hong.myfirstkotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hong.myfirstkotlinproject.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {
            val email = binding.email.text.toString()
            val pw = binding.pw.text.toString()

            auth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this) { task ->
                    val value = if (task.isSuccessful) {
                        startActivity(Intent(this,MainActivity::class.java))
                    } else {

                        Toast.makeText( baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}