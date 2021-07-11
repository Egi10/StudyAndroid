package com.example.studyandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.studyandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /**
         * Mengubah Title
         */
        title = "Main Activity"

        binding.btnSend.setOnClickListener {
            val message = binding.etName.text.toString()

            if (message.isNotEmpty()) {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.MESSAGE, message)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Message Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSendResult.setOnClickListener {
            val message = binding.etName.text.toString()

            if (message.isNotEmpty()) {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putExtra(DetailsActivity.MESSAGE, message)
                result.launch(intent)
            } else {
                Toast.makeText(this, "Message Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnNavigationComponent.setOnClickListener {
            val intent = Intent(this, NavigationComponentActivity::class.java)
            startActivity(intent)
        }

        viewModel.name.observe(this, {
            binding.tvName.text = it
        })
    }

    private val result =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when(it.resultCode) {
                DetailsActivity.RESULT -> {
                    val data = it.data
                    val message = data?.getStringExtra(MESSAGE)

                    binding.tvName.text = message
                }
            }
        }

    companion object {
        const val MESSAGE = "message"
    }
}