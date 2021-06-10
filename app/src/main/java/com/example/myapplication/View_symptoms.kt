package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class View_symptoms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_symptoms)
        val mAuth = FirebaseAuth.getInstance()
        var database = FirebaseDatabase.getInstance().getReference("symptom")

        val dr_sym_tv=findViewById<TextView>(R.id.dr_sym_tv)

        var getdata = object: ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {
                dr_sym_tv.setText("oOps !!")

            }
            override fun onDataChange(p0: DataSnapshot) {

                var sb = StringBuilder()
                for (i in p0.children) {
                    var sys1 = i.child("symptomdata").getValue()
                    var syname =i.child("s_name").getValue()
                    var data= syname.toString() + "::" + sys1.toString()
                    sb.append("      \n$syname :: $sys1 \n\n")
                }
                dr_sym_tv.setText(sb)
            }
        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)





    }



}