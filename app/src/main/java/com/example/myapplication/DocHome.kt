package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DocHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_home)

        var database = FirebaseDatabase.getInstance().getReference("user")
        val mAuth = FirebaseAuth.getInstance()


        val dr_signout =findViewById<ImageButton>(R.id.dr_home_signout)


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