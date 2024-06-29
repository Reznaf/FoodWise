package com.example.foodwise

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResetPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.reset_password)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val emailInput = findViewById<EditText>(R.id.email_input)
        val resetButton = findViewById<Button>(R.id.reset_password_button)

        backButton.setOnClickListener {
            finish()
        }

        resetButton.setOnClickListener {
            val email = emailInput.text.toString()
            // Send email to reset password
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcome_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}