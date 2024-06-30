package com.example.foodwise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)

        val backButton = findViewById<ImageButton>(R.id.back_button)

        backButton.setOnClickListener {
            finish()
        }

        val logout = findViewById<Button>(R.id.logout_button)
        logout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
    }
}