package com.example.birthdaygreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun createBirthdayCard(view: android.view.View) {
        val name = nameInput.editableText.toString()
        //intent is used to call another screen from this screen
        val intent = Intent(this, BirthdayGreetingActivity:: class.java)
//        intent.putExtra("name", name)
        intent.putExtra(BirthdayGreetingActivity.Name_Extra,name)
        startActivity(intent)
    }
}