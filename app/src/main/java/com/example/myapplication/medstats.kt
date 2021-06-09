package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_medstats.*

class medstats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medstats)

        val mAuth = FirebaseAuth.getInstance()

        //updating data to firebase
        var database = FirebaseDatabase.getInstance().getReference("symptom")

        val username = mAuth.currentUser
        val uid = username!!.uid

        var getdata = object: ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {


            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                for (i in p0.children) {
                      var sys1 = i.child("symptomdata").getValue()
                        if( uid == (i.key) ){
                            sb.append(" $sys1 \n")
                             }

                                          }
                medview.setText(sb)
            }


        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)


        var homebtn = findViewById<ImageButton>(R.id.medstat_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }

    }


    /*private fun data(){
        var getdata = object: ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                var sb = StringBuilder()
                for (i in p0.children) {
                    var name1 = i.child("name").getValue()
                    sb.append("${i.key} $name1 \n")
                }
                medview.setText(sb)
            }


        }
        database.addValueEventListener(getdata)
        database.addListenerForSingleValueEvent(getdata)
    }*/

}