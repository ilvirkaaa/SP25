package com.example.sp25

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val emailTextView: TextView = findViewById(R.id.emailTextView)
        val passwordTextView: TextView = findViewById(R.id.passwordTextView)

        val email = intent.getStringExtra("EMAIL") ?: ""
        val password = intent.getStringExtra("PASSWORD") ?: ""

        emailTextView.text = "Email: $email"
        passwordTextView.text = "Пароль: $password"
    }
}