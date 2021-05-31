package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class forgot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        val pass = findViewById<Button>(R.id.reset_pass)


        pass.setOnClickListener(View.OnClickListener{
                View->reset()
        })
    }

   private fun reset(){
       val eid = findViewById<View>(R.id.pass_mail) as EditText
       var reset_id = eid.text.toString()
       if (reset_id.isNotEmpty()) {
           FirebaseAuth.getInstance().sendPasswordResetEmail(reset_id).addOnCompleteListener{ task ->
               if (task.isSuccessful){

                   Toast.makeText(this, "Password reset link sent to your emial id !!! ", Toast.LENGTH_LONG).show()
                   startActivity(Intent(this,MainActivity::class.java))
                   finish()
               }
               else{
                   Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
               }
           }

       }
       else{
           Toast.makeText(this, "Enter your emial id !!! ", Toast.LENGTH_LONG).show()
       }
   }
}