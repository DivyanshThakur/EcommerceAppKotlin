package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_image_downloader.*

class ImageDownloader : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_downloader)

        btnGetImageActivity.setOnClickListener {


            val imageURL = "http://192.168.43.186/mobile.png"
            Picasso.get().load(imageURL).into(imageDownloade)


        }

    }
}
