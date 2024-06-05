package com.example.responsippab.ui.dashboard

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.responsippab.R

class DetailInstructorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_instructor)

        val detailPhoto: ImageView = findViewById(R.id.tv_photo)
        val detailName: TextView = findViewById(R.id.tv_name)
        val detailDetail: TextView = findViewById(R.id.tv_detail)

        val photo = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val detail = intent.getStringExtra("detail")

        detailPhoto.setImageResource(photo)
        detailName.text = name
        detailDetail.text = detail
    }
}