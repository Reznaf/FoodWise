package com.example.foodwise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cart)

        val backButton = findViewById<ImageButton>(R.id.back_button)
        val checkoutButton = findViewById<Button>(R.id.checkout)

        backButton.setOnClickListener {
            finish()
        }

        checkoutButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }

    }
}