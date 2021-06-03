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

class docSignup : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doc_signup)

        val submit = findViewById<View>(R.id.dr_sconfirm) as Button
        mDatabase = FirebaseDatabase.getInstance().getReference("Doc_Signup")
        submit.setOnClickListener(View.OnClickListener{
                View ->registerdoc()
        })
    }
    private fun registerdoc(){
        val dr_nameTxt = findViewById<View>(R.id.dr_SName) as EditText
        val dr_emailTxt = findViewById<View>(R.id.dr_mail) as EditText
        val dr_passwordTxt = findViewById<View>(R.id.dr_signpass) as EditText
        val dr_passTxtCon = findViewById<View>(R.id.dr_signpasscon) as EditText
        var dr_email = dr_emailTxt.text.toString()
        var dr_password = dr_passwordTxt.text.toString()
        var dr_conpassword = dr_passTxtCon.text.toString()
        var dr_name = dr_nameTxt.text.toString()
        if(dr_password==dr_conpassword){

            if(!dr_email.isEmpty() && !dr_password.isEmpty() && !dr_name.isEmpty() ){

                mAuth.createUserWithEmailAndPassword(dr_email, dr_password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful){

                        val user = mAuth.currentUser
                        val uid = user!!.uid
                        mDatabase.child(uid).child("Doc_Signup").setValue(dr_name)
                        Toast.makeText(this, "Hai ${dr_name} you are Successfully Registered", Toast.LENGTH_LONG).show()
                        //startActivity(Intent(this,docUpdate::class.java))
                        Toast.makeText(this,"update your profile", Toast.LENGTH_LONG).show()
                        finish()

                    }
                    else{
                        Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                })

            } else{

                Toast.makeText(this,"Please provide the signup details !!! ", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this,"ERROR : Passwords must be same !!! ", Toast.LENGTH_LONG).show()
        }
    }
}