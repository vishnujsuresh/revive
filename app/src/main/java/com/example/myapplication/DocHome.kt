package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DocHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_home)

        var database = FirebaseDatabase.getInstance().getReference("user")
        val mAuth = FirebaseAuth.getInstance()

        val dpro=findViewById<Button>(R.id.dr_update)

        val dr_signout =findViewById<ImageButton>(R.id.dr_home_signout)
        val dr_sym = findViewById<Button>(R.id.dr_sym_btn)

        dr_sym.setOnClickListener {



        }
        dr_sym.setOnClickListener {
            startActivity(Intent(this,View_symptoms::class.java))
        }

        val username = mAuth.currentUser
        val uid = username!!.uid

        dr_signout.setOnClickListener{

            mAuth.signOut()
            Toast.makeText(this, "signing out  ", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,welcome::class.java))
            finish()
        }

    }
}