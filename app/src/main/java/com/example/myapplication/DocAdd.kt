package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class DocAdd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_add)

        val mAuth = FirebaseAuth.getInstance()
        var database = FirebaseDatabase.getInstance().getReference("doctor")
        val submit = findViewById<Button>(R.id.dr_add)
        val username = mAuth.currentUser
        val uid = username!!.uid


        submit.setOnClickListener {

            var dssn = findViewById<EditText>(R.id.dr_assn)
            val dname = findViewById<EditText>(R.id.dr_aname)
            val dclinic = findViewById<EditText>(R.id.dr_aclinic)
            val dmob = findViewById<EditText>(R.id.dr_aphn)
            val dexp = findViewById<EditText>(R.id.dr_aexp)
            val dspec = findViewById<EditText>(R.id.dr_aspec)

            var ssn = dssn.text.toString().toInt()
            var name = dname.text.toString()
            var clinic = dclinic.text.toString()
            var mob = dmob.text.toString()
            var exp = dexp.text.toString().toInt()
            var spec = dspec.text.toString()

            if (mob.length > 0 && ssn>0 && name.length>0 && clinic.length>0 && exp>0 && spec.length>0) {
                if (mob.length == 10) {
                    database.child(uid.toString()).setValue(doctor(uid, ssn, name, clinic, mob, exp, spec))
                    Toast.makeText(this, "profile Updated ", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, DocHome::class.java))
                }
                else{
                    Toast.makeText(this, "Check Your Mobile  Number", Toast.LENGTH_LONG).show()
                }
            }
            else{
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()
            }

        }


    }
}