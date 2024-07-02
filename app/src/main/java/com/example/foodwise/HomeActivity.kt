package com.example.foodwise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodwise.Domain.Location
import com.example.foodwise.databinding.HomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeActivity : AppCompatActivity() {

    lateinit var binding: HomeBinding
    lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLocation()
        //initFood()

        binding.buyButton.setOnClickListener(){
            val intent = Intent(this, CartActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.sellButton.setOnClickListener(){
            val intent = Intent(this, AddOrderActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.orderButton.setOnClickListener(){
            val intent = Intent(this, MyOrderActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.avatarButton.setOnClickListener(){
            val intent = Intent(this, ProfileActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.foodCard.setOnClickListener(){
            val intent = Intent(this, FoodDescActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.foodCard2.setOnClickListener(){
            val intent = Intent(this, FoodDesc2Activity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.foodCard3.setOnClickListener(){
            val intent = Intent(this, FoodDesc3Activity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }
        binding.foodCard4.setOnClickListener(){
            val intent = Intent(this, FoodDesc4Activity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(
                this,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            ).toBundle()
            startActivity(intent, options)
        }

    }
    
    private fun initLocation() {

        val myRef = FirebaseDatabase.getInstance().getReference("location")
        val list = ArrayList<Location>()
        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (data in snapshot.children) {
                    val location = data.getValue(Location::class.java)
                    location?.let { list.add(it) }
                }
                val adapter =ArrayAdapter(this@HomeActivity, R.layout.location_text, list)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.location.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error appropriately, e.g., log it
                Log.e("Firebase", "Error: ${error.message}")
            }
        })

    }

//    private fun initFood() {
//
//        val myRef = FirebaseDatabase.getInstance().getReference("food")
//        binding.progressBar.visibility = View.VISIBLE
//        val list = ArrayList<Food>()
//        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for (data in snapshot.children) {
//                    val food = data.getValue(Food::class.java)
//                    food?.let { list.add(it)
//                        Log.i("Add Food", "added 1")}
//
//                }
//                if (list.isEmpty()) {
//                    val manager = LinearLayoutManager(
//                        this@HomeActivity,
//                        LinearLayoutManager.HORIZONTAL,
//                        false
//                    )
//                    binding.nearFoodView.setLayoutManager(manager)
//                    binding.nearFoodView.adapter = NearAdapter(list)
//                }
//                binding.progressBar.visibility = View.GONE
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Handle the error appropriately, e.g., log it
//                Log.e("Firebase", "Error: ${error.message}")
//            }
//        })
//
//    }
}