package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.database.*

class home : AppCompatActivity() {

    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val dispTxt =  findViewById<View>(R.id.textView6) as TextView

        mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val result =snapshot.child("Names").toString()
                dispTxt.text="Hai Welcom back" + result
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })


        val bookdrvar= findViewById<Button>(R.id.bookslotbutton)
        val personaldetailsvar= findViewById<Button>(R.id.updatebutton)
        val symptomsvar=findViewById<Button>(R.id.symptombutton)
        val medststsvar=findViewById<Button>(R.id.medrecordbutton)
        val autopredictionvar=findViewById<Button>(R.id.docbotbutton)
        bookdrvar.setOnClickListener{
            val intent = Intent(this@home,bookdr::class.java)
            startActivity(intent)

        }
        personaldetailsvar.setOnClickListener{
            var intent = Intent(this@home,personaldetailsactivity::class.java)
            startActivity(intent)
        }
        symptomsvar.setOnClickListener{
            val intent = Intent(this@home,symptommanagement::class.java)
            startActivity(intent)
        }
        medststsvar.setOnClickListener{
            val intent = Intent(this@home,medstats::class.java)
            startActivity(intent)
        }
        autopredictionvar.setOnClickListener{
            val intent = Intent(this@home,drbot::class.java)
            startActivity(intent)
        }
    }

 /*   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.id.signout)
        return super.onCreateOptionsMenu(menu)
    } */
}