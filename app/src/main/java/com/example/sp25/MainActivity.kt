package com.example.sp25

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var modelsList: MutableList<ItemModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val randomCount = (2..6).random()
        modelsList = generateOrderedModels(randomCount).toMutableList()

        adapter = ItemAdapter(modelsList,
            onItemClick = { position ->
                val model = modelsList[position]
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("imageUrl", model.imageUrl)
                    putExtra("title", model.title)
                    putExtra("description", model.description)
                }
                startActivity(intent)
            },
            onImageClick = { position ->
                val sampleImages = listOf(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Example.jpg/320px-Example.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/HST-SM4.jpeg/320px-HST-SM4.jpeg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/320px-Golde33443.jpg",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/320px-Image_created_with_a_mobile_phone.png"
                )
                val newImageUrl = sampleImages.random()
                adapter.updateImageAt(position, newImageUrl)
            })

        recyclerView.adapter = adapter
    }
}