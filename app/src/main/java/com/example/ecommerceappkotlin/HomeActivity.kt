package com.example.ecommerceappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnMainActivity.setOnClickListener {

                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

        }

        btnGetJsonObjects.setOnClickListener {

            val intent = Intent(this,ShowJsonObjectActivity::class.java)
            startActivity(intent)

        }

        btnGetJsonArray.setOnClickListener {

            val intent = Intent(this,GetAllJSONObjectActivity::class.java)
            startActivity(intent)

        }

        btnGetImageActivity.setOnClickListener {

            val intent = Intent(this,ImageDownloader::class.java)
            startActivity(intent)

        }

        btnRecyclerView.setOnClickListener {

            val intent = Intent(this,RvActivity::class.java)
            startActivity(intent)
        }

    }
}
