package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    private var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()


        val signupvar = findViewById<Button>(R.id.signupButton)
        val loginvar = findViewById<Button>(R.id.login_button)
        val emailvar = findViewById<EditText>(R.id.loginmail)
        val passvar = findViewById<EditText>(R.id.password)

        signupvar.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2signup::class.java)
            startActivity(intent)

        }

       loginvar.setOnClickListener {
            val intent = Intent(this@MainActivity, home::class.java)
            startActivity(intent)

        }

        fun buLoginEvent(view:View){

            //signu event when signup is clicked
            val email= emailvar.text.toString()
            val password= passvar.text.toString()
            //loginToFirebase(email,password)
        }

        fun loginToFirebase(email:String,password:String){
            mAuth!!.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(applicationContext,"login Successful",Toast.LENGTH_LONG).show()
                            //Log.d("login:",mAuth!!.currentUser)
                        }
                        else{
                            Toast.makeText(applicationContext,"login Failed",Toast.LENGTH_LONG).show()
                        }


                    }
        }
    }
}