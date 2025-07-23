package com.example.sp25

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()
        val imageView: ImageView = findViewById(R.id.imageViewDetail)
        val titleView: TextView = findViewById(R.id.textViewTitleDetail)
        val descriptionView: TextView = findViewById(R.id.textViewDescriptionDetail)

        val imageUrl = intent.getStringExtra("imageUrl")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        Glide.with(this)
            .load(imageUrl)
            .placeholder(android.R.color.darker_gray)
            .error(android.R.color.holo_red_dark)
            .into(imageView)

        titleView.text = title
        descriptionView.text = description
    }
}