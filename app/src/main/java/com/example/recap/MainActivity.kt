package com.example.recap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.button)
        val button2:Button = findViewById(R.id.button2)



        button.setOnClickListener{
            Toast.makeText(this, "Virat Kohli", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , new_page::class.java)
            val value = "Virat Kohli"
            intent.putExtra("key" , value)
            startActivity(intent)
        }
        button2.setOnClickListener{
            Toast.makeText(this, "Rohit Sharma", Toast.LENGTH_SHORT).show()
            val intent = Intent(this , new_page::class.java)
            val value = "Rohit Sharma"
            intent.putExtra("key" , value)
            startActivity(intent)

        }
    }
}