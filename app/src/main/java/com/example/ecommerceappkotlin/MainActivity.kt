package com.example.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedP : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            sharedP = getSharedPreferences("addData", Context.MODE_PRIVATE)
            var myEditor = sharedP?.edit()

            myEditor?.putString("product_name",edtProduct.text.toString())
            myEditor?.apply()

            Toast.makeText(this@MainActivity, "Product saved successfully",Toast.LENGTH_SHORT).show()
        }

        btnGet.setOnClickListener {
            txtData.text = sharedP?.getString("product_name", "nothing")
        }

    }
}
