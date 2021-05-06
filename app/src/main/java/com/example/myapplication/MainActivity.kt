package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.AuthResult


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var auth = FirebaseAuth.getInstance();



        val signupvar= findViewById<Button>(R.id.signupButton)
        val loginvar= findViewById<Button>(R.id.login_button)

        loginvar.setOnClickListener{
          //  if ()
        }




}

}