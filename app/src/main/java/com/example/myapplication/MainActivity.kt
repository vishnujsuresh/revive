package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.AuthResult


class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val signupvar= findViewById<Button>(R.id.signupButton)
        val loginvar= findViewById<Button>(R.id.login_button)

        loginvar.setOnClickListener(View.OnClickListener{
          View->login()
        } )


       signupvar.setOnClickListener(View.OnClickListener{
           View->register()
       })


}
    private fun login () {

        val emailTxt = findViewById<View>(R.id.loginmail) as EditText
        val passwordTxt = findViewById<View>(R.id.password) as EditText
        var email = emailTxt.text.toString()
        var password = passwordTxt.text.toString()
        if(!email.isEmpty() && !password.isEmpty()){

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this,OnCompleteListener{task ->
                if (task.isSuccessful){
                    startActivity(Intent(this,home::class.java))
                    Toast.makeText(this,"Login Successful !! ",Toast.LENGTH_LONG).show()
                }else
                {
                    Toast.makeText(this,"Login Failed , Incorrect details",Toast.LENGTH_LONG).show()
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