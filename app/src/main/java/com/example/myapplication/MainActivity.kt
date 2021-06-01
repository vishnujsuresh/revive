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


class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance();
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        val signupvar= findViewById<Button>(R.id.dr_signupButton)
        val loginvar= findViewById<Button>(R.id.dr_login_button)
        val pass = findViewById(R.id.tv_forgot)as TextView
        val drlink = findViewById(R.id.dr_link_tv)as TextView

        loginvar.setOnClickListener(View.OnClickListener{
          View->login()
        } )


       signupvar.setOnClickListener(View.OnClickListener{
           View->register()
       })
        pass.setOnClickListener(View.OnClickListener{
            startActivity(Intent(this,forgot::class.java)) })

        drlink.setOnClickListener(View.OnClickListener{
            startActivity(Intent(this,welcome::class.java)) })
}
    private fun login () {

        val emailTxt = findViewById<View>(R.id.dr_loginmail) as EditText
        val passwordTxt = findViewById<View>(R.id.dr_password) as EditText
        var email = emailTxt.text.toString()
        var password = passwordTxt.text.toString()
        if(!email.isEmpty() && !password.isEmpty()){

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,OnCompleteListener{task ->
                if (task.isSuccessful){
                    startActivity(Intent(this,home::class.java))
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
    private fun register(){

        startActivity(Intent(this,signup::class.java))
    }
}