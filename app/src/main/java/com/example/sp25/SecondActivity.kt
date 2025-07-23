package com.example.sp25

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class SecondActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        submitButton = findViewById(R.id.submitButton)
        submitButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateInputs()
            }
        }

        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        submitButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("EMAIL", email)
                putExtra("PASSWORD", password)
            }
            startActivity(intent)
        }
    }

    private fun validateInputs() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        val isEmailValid = isValidEmail(email)
        val isPasswordValid = isValidPassword(password)

        submitButton.isEnabled = isEmailValid && isPasswordValid
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return Pattern.compile(emailPattern).matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false

        var hasDigit = false
        var hasUpperCase = false
        var hasLowerCase = false

        for (c in password) {
            when {
                c.isDigit() -> hasDigit = true
                c.isUpperCase() -> hasUpperCase = true
                c.isLowerCase() -> hasLowerCase = true
            }
        }

        return hasDigit && hasUpperCase && hasLowerCase
    }
}