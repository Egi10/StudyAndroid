package com.example.studyandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.studyandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)

//        val etName = findViewById<TextInputEditText>(R.id.et_name)
//        val btnSend = findViewById<MaterialButton>(R.id.btn_send)
//        val tvName = findViewById<MaterialTextView>(R.id.tv_name)

//        binding.btnSend.setOnClickListener {
//            viewModel._name.value = binding.etName.text.toString()
//
//            viewModel.name.observe(this, {
//                binding.tvName.text = it
//            })
//        }
//
//        viewMsd
    }
}