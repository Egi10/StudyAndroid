package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studyandroid.databinding.ActivityNavigationComponentBinding

class NavigationComponentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Mengubak Title
         */
        title = "Navigation Component"
    }
}