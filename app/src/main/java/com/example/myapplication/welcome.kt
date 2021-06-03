package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class welcome : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance();
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        mDatabase = FirebaseDatabase.getInstance().getReference("Doc_Names")

        val dsignbtn=findViewById<Button>(R.id.dr_signupButton);
        dsignbtn.setOnClickListener(View.OnClickListener{
                View->signupfun()
        } )


    }
    private fun signupfun()
    {
        startActivity(Intent(this,docSignup::class.java))
    }
}