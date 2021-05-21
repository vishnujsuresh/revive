package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class symptommanagement : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptommanagement)


        val mAuth = FirebaseAuth.getInstance()
        //updating data to firebase
        var database = FirebaseDatabase.getInstance().getReference("symptom")
        val sysupdate = findViewById<Button>(R.id.applybutton)
        val username = mAuth.currentUser
        val uid = username!!.uid
        sysupdate.setOnClickListener{
            var sadd = findViewById<EditText>(R.id.addsymptoms)
            val smore = findViewById<EditText>(R.id.description)

            var add = sadd.text.toString()
            var more = smore.text.toString()
            var symptomdata=add+":-"+more
            database.child(uid.toString()).setValue(symptom(uid,symptomdata))
            Toast.makeText(this, "Symptom ${add} Added ", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }




    }
}