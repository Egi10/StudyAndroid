package com.example.studyandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.example.studyandroid.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Mengubah Text Title
         */
        title = "Detail Activity"

        val intent = intent
        val message = intent.getStringExtra(MESSAGE)

        binding.tvMessage.text = message
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent()
            intent.putExtra(MainActivity.MESSAGE, "Aku Kembali")
            setResult(RESULT, intent)
            finish()

            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    companion object {
        const val MESSAGE = "message"

        const val RESULT = 10
    }
}