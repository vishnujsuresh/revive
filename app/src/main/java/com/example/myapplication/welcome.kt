package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val dsignbtn=findViewById<Button>(R.id.dr_signupButton);
        dsignbtn.setOnClickListener(View.OnClickListener{
                View->signupfun()
        } )


    }
    private fun signupfun()
    {
        startActivity(Intent(this,dr_signup::class.java))
    }
}