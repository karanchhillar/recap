package com.example.recap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val email1:TextView = findViewById(R.id.email_id)
        val password1:TextView = findViewById(R.id.pass_id)
        val confirm_password1:TextView = findViewById(R.id.conf_pass_id)
        val signup_button:Button= findViewById(R.id.signup_button_id)

        val auth = FirebaseAuth.getInstance()

        signup_button.setOnClickListener{
            val email:String = email1.text.toString()
            val password = password1.text.toString()
            val confirm_password = confirm_password1.text.toString()

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirm_password)){
                Toast.makeText(this, "You cannot leave any field empty.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 2){
                Toast.makeText(this, "Password should be greater than 2 letters.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != confirm_password){
                Toast.makeText(this, "Password and Confirm Password does not match.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{karan ->

                if (karan.isSuccessful){
                    Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}