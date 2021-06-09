package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_view_symptoms.*

class View_symptoms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_symptoms)


        val mAuth = FirebaseAuth.getInstance()

        //updating data to firebase
        var database = FirebaseDatabase.getInstance().getReference("symptom")



        var getdata = object: ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {


            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                for (i in p0.children) {
                    var sys1 = i.child("symptomdata").getValue()
                    sb.append(" \n $sys1 \n\n")
                }
                dr_sym_tv.setText(sb)
            }


        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)




    }





}