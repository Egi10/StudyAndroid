package com.example.studyandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import coil.transform.CircleCropTransformation
import com.example.studyandroid.databinding.ActivityDetailRecyclerViewBinding

class DetailRecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Food>("data")

        binding.ivImage.load(data?.image) {
            transformations(CircleCropTransformation())
        }
        binding.tvText.text = data?.text
    }
}