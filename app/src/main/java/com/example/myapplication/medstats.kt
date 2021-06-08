package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class medstats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medstats)

        val mAuth = FirebaseAuth.getInstance()

        //updating data to firebase
        var database = FirebaseDatabase.getInstance().getReference("symptom")


        var homebtn = findViewById<ImageButton>(R.id.medstat_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }

    }


}