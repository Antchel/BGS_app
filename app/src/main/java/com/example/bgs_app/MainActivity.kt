package com.example.bgs_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun touchme (view: View) {

        val mytouch = Toast.makeText(this,"You have no rules",Toast.LENGTH_SHORT)

        mytouch.show()
    }
    fun cont (view: View) {
        val contintent = Intent (this,SecondActivity::class.java)
        startActivity(contintent)
    }
}
