package net.nathan.vinchou

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.nathan.vinchou.databinding.ActivityMainBinding
import net.nathan.vinchou.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}