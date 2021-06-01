package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
        getData()

        var homebtn = findViewById<ImageButton>(R.id.medstat_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }

    }
    private fun getData(){

        var getdata = object : ValueEventListener{

            override fun onCancelled(p0: DatabaseError) {
                Log.e("cancel",p0.toString())
            }
            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                for (i in p0.children) {
                   var sdata = i.child("symptomdata").getValue()
                    sb.append("${i.key} $sdata")
                }
                val recordview=findViewById<TextView>(R.id.medview).apply {
                    text=sb
                }
            }

        }


    }

}