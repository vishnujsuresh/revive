package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class home : AppCompatActivity() {



    var database = FirebaseDatabase.getInstance().getReference("user")
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

/*
        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.main_menu,menu);
            return true
        }

         fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId;
            if (id == R.id.signoutmenu){
                Toast.makeText(this, "Siging Out", Toast.LENGTH_SHORT).show()
                return true
            }else if (id == R.id.homemenu){
                startActivity(Intent(this,home::class.java))
                return true
            }else if (id == R.id.updatemenu){
                startActivity(Intent(this,personaldetailsactivity::class.java))
                return true
            }else if (id == R.id.bookmenu){
                startActivity(Intent(this,bookdr::class.java))
                return true
            }else if (id == R.id.medstatmenu){
                startActivity(Intent(this,medstats::class.java))
                return true
            }else if (id == R.id.drbotmenu){
                startActivity(Intent(this,drbot::class.java))
                return true
            }
            return super.onOptionsItemSelected(item)
        }
 */
        val username = mAuth.currentUser
        val uid = username!!.uid
        val signout = findViewById<ImageButton>(R.id.signout_btn)

        signout.setOnClickListener{

            mAuth.signOut()
            Toast.makeText(this, "signing out  ", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivity::class.java))
        }

       // finish()











        val dispTxt =  findViewById<View>(R.id.textView6) as TextView




        val bookdrvar= findViewById<Button>(R.id.bookslotbutton)
        val personaldetailsvar= findViewById<Button>(R.id.updatebutton)
        val symptomsvar=findViewById<Button>(R.id.symptombutton)
        val medststsvar=findViewById<Button>(R.id.medrecordbutton)
        val autopredictionvar=findViewById<Button>(R.id.docbotbutton)
        bookdrvar.setOnClickListener{
            val intent = Intent(this@home,bookdr::class.java)
            startActivity(intent)

        }
        personaldetailsvar.setOnClickListener{
            var intent = Intent(this@home,personaldetailsactivity::class.java)
            startActivity(intent)
        }
        symptomsvar.setOnClickListener{
            val intent = Intent(this@home,symptommanagement::class.java)
            startActivity(intent)
        }
        medststsvar.setOnClickListener{
            val intent = Intent(this@home,medstats::class.java)
            startActivity(intent)
        }
        autopredictionvar.setOnClickListener{
            val intent = Intent(this@home,drbot::class.java)
            startActivity(intent)
        }
    }

 /*   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.id.signout)
        return super.onCreateOptionsMenu(menu)
    } */
}