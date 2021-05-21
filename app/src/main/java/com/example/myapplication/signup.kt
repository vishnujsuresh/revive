package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val regBtn = findViewById<View>(R.id.confirm) as Button

        mDatabase =FirebaseDatabase.getInstance().getReference("Signup")

        regBtn.setOnClickListener(View.OnClickListener{
            View ->register()
        })


    }

    private fun register() {
        val nameTxt = findViewById<View>(R.id.SName) as EditText
        val emailTxt = findViewById<View>(R.id.mail) as EditText
        val passwordTxt = findViewById<View>(R.id.signpass) as EditText
        val passTxtCon = findViewById<View>(R.id.signpasscon) as EditText
        var email = emailTxt.text.toString()
        var password = passwordTxt.text.toString()
        var conpassword = passTxtCon.text.toString()
        var name = nameTxt.text.toString()
       if(password==conpassword){

        if(!email.isEmpty() && !password.isEmpty() && !name.isEmpty() ){

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful){

                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Signup").setValue(name)
                    Toast.makeText(this, "Hai ${name} you are Successfully Registered",Toast.LENGTH_LONG).show()
                    startActivity(Intent(this,personaldetailsactivity::class.java))
                    Toast.makeText(this,"update your profile",Toast.LENGTH_LONG).show()

                }
                else{
                    Toast.makeText(this,"ERROR :( try again ", Toast.LENGTH_LONG).show()
                }
            })

        } else{

            Toast.makeText(this,"Please provide the signup details !!! ", Toast.LENGTH_LONG).show()
            }
       } else {
           Toast.makeText(this,"ERROR : Passwords must be same !!! ",Toast.LENGTH_LONG).show()
       }
    }
}