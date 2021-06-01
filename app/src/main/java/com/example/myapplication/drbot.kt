package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class drbot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drbot)

        var homebtn = findViewById<ImageButton>(R.id.bot_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }
    }
}