package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

class MainActivity2signup : AppCompatActivity() {


    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2signup)
        val signupvar= findViewById<Button>(R.id.signupButton)


        auth = FirebaseAuth.getInstance()





        }




    }
