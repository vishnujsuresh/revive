package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class bookdr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookdr)


        var homebtn = findViewById<ImageButton>(R.id.bookdr_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivityR2::class.java))
        }

    }
}