package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
            val sy_name = findViewById<EditText>(R.id.sym_name)

            var add = sadd.text.toString()
            var more = smore.text.toString()
            var s_name = sy_name.text.toString()
            if (add.isNotEmpty()&&more.isNotEmpty() && s_name.isNotEmpty() ){
                     var symptomdata=add+":- "+more
                    database.child(uid.toString()).setValue(symptom(uid,s_name,symptomdata))

                    Toast.makeText(this, "Symptom ${add} Added ", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,home::class.java))
            }
            else {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()


            }
            }

        var homebtn = findViewById<ImageButton>(R.id.sysmptom_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }
        }




}
