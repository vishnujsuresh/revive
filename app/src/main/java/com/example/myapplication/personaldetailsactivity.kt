package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.AccessControlProfileId
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.myapplication.R.id.profupdate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class personaldetailsactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personaldetailsactivity)




             val mAuth = FirebaseAuth.getInstance()
            //updating data to firebase
            var database = FirebaseDatabase.getInstance().getReference("user")
            val update = findViewById<Button>(R.id.profupdate)
            val username = mAuth.currentUser
            val uid = username!!.uid

             update.setOnClickListener {

                 var pssn = findViewById<EditText>(R.id.profssn)
                 val pname = findViewById<EditText>(R.id.profname)
                 val paddr = findViewById<EditText>(R.id.profaddr)
                 val pmob = findViewById<EditText>(R.id.profmobno)
                 val page = findViewById<EditText>(R.id.profage)
                 val pgender = findViewById<EditText>(R.id.profgender)

                 var ssn = pssn.text.toString().toInt()
                 var name = pname.text.toString()
                 var addr = paddr.text.toString()
                 var mob = pmob.text.toString()
                 var age = page.text.toString().toInt()
                 var gender = pgender.text.toString()

                 if (mob.length > 0 && ssn>0 && name.length>0 && addr.length>0 && age>0 && gender.length>0) {
                     if (mob.length == 10) {
                         database.child(uid.toString())
                             .setValue(user(uid, ssn, name, addr, mob, age, gender))
                         Toast.makeText(this, "profile Updated ", Toast.LENGTH_LONG).show()
                         startActivity(Intent(this, home::class.java))
                     }
                     else{
                         Toast.makeText(this, "Check Your Mobile  Number", Toast.LENGTH_LONG).show()
                     }
                 }
                 else{
                     Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()
                 }

             }
        //   setSupportActionBar(findViewByIdR.id.updatetoolbar))

        var homebtn = findViewById<ImageButton>(R.id.update_home)
        homebtn.setOnClickListener {
            Toast.makeText(this,"Home",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,home::class.java))
        }

    }

















    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
}


