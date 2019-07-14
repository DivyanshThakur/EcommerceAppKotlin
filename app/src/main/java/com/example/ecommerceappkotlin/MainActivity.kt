package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        largeRB.setOnClickListener {
            text.setTextSize(50f);

        }
        mediumRB.setOnClickListener {
            text.setTextSize(20f);

        }

        smallRB.setOnClickListener {
            text.setTextSize(10f);
        }
    }
}
