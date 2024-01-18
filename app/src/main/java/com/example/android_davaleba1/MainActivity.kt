package com.example.android_davaleba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_davaleba1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter: MobilesAdapter = MobilesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMobiles.adapter = adapter

        observer()

    }

    private fun observer() {
        lifecycleScope.launch {
            val response = Retrofit.api.getItems()

            if (response.isSuccessful) {
                adapter.submitList(response.body())
            }
        }
    }
}