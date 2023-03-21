package com.example.recap

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class new_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_page)

        val str:String = intent.getStringExtra("key").toString()
        val image:ImageView = findViewById(R.id.imageView2)

        val login_button:Button = findViewById(R.id.login_button)
        val signup_button:Button = findViewById(R.id.signup_button)


        val text:TextView = findViewById(R.id.textView2)
        text.text = str
//        text.setText(str)
        // Dono chl rahe hai

        if (str == "Virat Kohli"){
            image.setImageResource(R.drawable.kohli)
        }
        else if (str == "Rohit Sharma"){
            image.setImageResource(R.drawable.rohit)
        }
        else{
            Toast.makeText(this, "hag diya", Toast.LENGTH_SHORT).show()
        }

        login_button.setOnClickListener{
            val intent1 = Intent(this , login_page::class.java)
            startActivity(intent1)
        }

        signup_button.setOnClickListener{
            val intent1 = Intent(this, Sign_up::class.java)
            startActivity(intent1)
        }

    }

}