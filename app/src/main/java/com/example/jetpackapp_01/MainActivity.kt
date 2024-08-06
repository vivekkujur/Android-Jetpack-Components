package com.example.jetpackapp_01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackapp_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var mainViewModel  :MainViewModel
   lateinit var binding :ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        mainViewModel = ViewModelProvider(this,MainViewModelFactory()).get(MainViewModel::class.java)
        binding.model = mainViewModel
        binding.lifecycleOwner= this

        mainViewModel.quoteLiveData.observe(this, Observer {

            Log.d("LiveData String data", "onCreate: $it ")

        })


    }
}