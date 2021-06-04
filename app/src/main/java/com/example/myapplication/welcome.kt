package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class welcome : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance();
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        mDatabase = FirebaseDatabase.getInstance().getReference("Doc_Names")

        val dsignbtn=findViewById<Button>(R.id.dr_signupButton);
        dsignbtn.setOnClickListener(View.OnClickListener{
                View->signupfun()
        } )
        val repass = findViewById(R.id.dr_tv_forgot)as TextView
        repass.setOnClickListener{
            startActivity(Intent(this,DocForgot::class.java))
        }

        val dlog = findViewById<Button>(R.id.dr_login_button)
        dlog.setOnClickListener (View.OnClickListener{
            View -> dr_login()
        })

    }
    private fun signupfun()
    {
        startActivity(Intent(this,docSignup::class.java))
    }

    private fun dr_login(){



        val dr_emailTxt = findViewById<View>(R.id.dr_loginmail) as EditText
        val dr_passwordTxt = findViewById<View>(R.id.dr_password) as EditText
        var email = dr_emailTxt.text.toString()
        var password = dr_passwordTxt.text.toString()
        if(!email.isEmpty() && !password.isEmpty()){

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener{ task ->
                if (task.isSuccessful){
                    startActivity(Intent(this,DocHome::class.java))
                    Toast.makeText(this,"Login Successful !! ",Toast.LENGTH_LONG).show()
                    finish()
                }else
                {
                    Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                }
            })


        }
        else
        {
            Toast.makeText(this,"Please provide the login details !!! ",Toast.LENGTH_LONG).show()
        }



    }
}