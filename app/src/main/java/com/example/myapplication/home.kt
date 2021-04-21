package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
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
}