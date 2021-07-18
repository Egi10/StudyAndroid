package com.example.studyandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studyandroid.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list: MutableList<Food> = mutableListOf()
        for (i in 0..100) {
            list.add(
                Food(
                    text = "Rendang $i",
                    image = "https://asset.kompas.com/crops/a29yE_hzxM0nJBIId_Lh6aeDkok=/0x3:977x654/780x390/data/photo/2020/06/30/5efaf91e0ec2c.jpg"
                )
            )
        }

        val adapter = FoodAdapter(list) {
            Toast.makeText(this, "Memilih ${it.text}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailRecyclerViewActivity::class.java)
            intent.putExtra("data", it)
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}