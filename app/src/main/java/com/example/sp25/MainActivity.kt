package com.example.sp25

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView

    private val picturesList = listOf(
        "https://picsum.photos/200/300?random=1",
        "https://picsum.photos/200/300?random=2",
        "https://picsum.photos/200/300?random=3",
        "https://picsum.photos/200/300?random=4",
        "https://picsum.photos/200/300?random=5",
        "https://picsum.photos/200/300?random=6",
        "https://picsum.photos/200/300?random=7",
        "https://picsum.photos/200/300?random=8",
        "https://picsum.photos/200/300?random=9",
        "https://picsum.photos/200/300?random=10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        val randomImageButton: Button = findViewById(R.id.randomImageButton)
        val goToSecondScreenButton: Button = findViewById(R.id.goToSecondScreenButton)

        randomImageButton.setOnClickListener {
            val randomIndex = (0 until 10).random()
            val imageUrl = picturesList[randomIndex]

            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.color.purple_200)
                .into(imageView)
        }

        goToSecondScreenButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}