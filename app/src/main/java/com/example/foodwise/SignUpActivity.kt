package com.example.foodwise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sign_up)

        val nameInput = findViewById<EditText>(R.id.name_input)
        val emailInput = findViewById<EditText>(R.id.email_input)
        val passInput = findViewById<EditText>(R.id.pass_input)
        val signUpButton = findViewById<Button>(R.id.sign_up)
        val toLogin = findViewById<TextView>(R.id.to_login)
        val facebookLogin = findViewById<Button>(R.id.facebook_login)
        val googleLogin = findViewById<Button>(R.id.google_login)
        firebaseAuth = FirebaseAuth.getInstance()

        toLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        signUpButton.setOnClickListener {
            val username = nameInput.text.toString()
            val email = emailInput.text.toString()
            val password = passInput.text.toString()
            if(username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.sign_up_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}