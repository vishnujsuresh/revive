package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

class home : AppCompatActivity() {

    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


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
















        val dispTxt =  findViewById<View>(R.id.textView6) as TextView

       /* mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val result =snapshot.child("Names").toString()
                dispTxt.text="Hai Welcom back" + result
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@home,";(",Toast.LENGTH_LONG).show()
            }
        }) */


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