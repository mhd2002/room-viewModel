package com.example.room

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.room.RoomDatabase.User
import com.example.room.RoomDatabase.UserDatabase
import com.example.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getAllUsersService().observe(this, Observer {

            try {
                for (i in it) {

                    binding.tv.append(i.email.toString())
                }

            } catch (e: Exception) {
                binding.tv.text = e.message
            }

        })

        binding.button.setOnClickListener {

            val user = User(0, "mahdi@gmail.com", "123456", "09137707200")
            viewModel.insertUser(user)

        }

    }
}