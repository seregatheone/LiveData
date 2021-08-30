package com.example.livedata

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.ViewManager
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    private lateinit var viewModelLive: ViewModelLive
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModelLive = ViewModelProvider(this)[ViewModelLive::class.java]
        viewModelLive.currentNumber.observe(this, {
            binding.textview.text = it.toString()
            binding.textview2.text = (it*it).toString()
        })
        //Button
        binding.incbut.setOnClickListener {
            viewModelLive.currentNumber.value = ++viewModelLive.number
        }
    }


}