package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class personaldetailsactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personaldetailsactivity)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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