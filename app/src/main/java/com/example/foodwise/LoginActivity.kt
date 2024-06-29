package com.example.foodwise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)

        val emailInput = findViewById<EditText>(R.id.email_input)
        val passInput = findViewById<EditText>(R.id.pass_input)
        val backButton = findViewById<ImageButton>(R.id.back_button)
        val loginButton = findViewById<Button>(R.id.login)
        val toSignUp = findViewById<TextView>(R.id.to_sign_up)
        val toForgotPassword = findViewById<TextView>(R.id.to_forgot_password)
        val facebookLogin = findViewById<Button>(R.id.facebook_login)
        val googleLogin = findViewById<Button>(R.id.google_login)
        firebaseAuth = FirebaseAuth.getInstance()

        backButton.setOnClickListener {
            finish()
        }

        toSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passInput.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, HomeActivity::class.java)
                        val options = ActivityOptionsCompat.makeCustomAnimation(
                            this,
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                        ).toBundle()
                        startActivity(intent, options)
                    }
                    else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "Empty Fields Are Not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }

        toForgotPassword.setOnClickListener {
            val intent = Intent(this, ResetPassActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }
}