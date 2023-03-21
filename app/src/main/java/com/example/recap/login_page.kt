
package com.example.recap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val email:TextView = findViewById(R.id.email)
        val password:TextView = findViewById(R.id.password)
        val letgo:Button = findViewById(R.id.letsgo)

        val auth = FirebaseAuth.getInstance()

        letgo.setOnClickListener{
            val emailtext = email.text.toString()
            val passwordtext = password.text.toString()
            auth.signInWithEmailAndPassword(emailtext , passwordtext).addOnCompleteListener{
                karan ->
                if (karan.isSuccessful){
                    Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                }

                else{
                    val error:String = karan.exception.toString()
                    Toast.makeText(this, "Something went Wrong $error", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}