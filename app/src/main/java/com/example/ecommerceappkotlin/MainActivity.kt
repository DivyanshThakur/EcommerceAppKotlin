package com.example.ecommerceappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGet.setOnClickListener {

            val serverURL = "http://192.168.43.186/PHPTest/test_file.php"
            val requestQ : RequestQueue = Volley.newRequestQueue(this@MainActivity)
            val stringRequest = StringRequest(Request.Method.GET, serverURL, Response.Listener { response ->
                txtData.text = response
            },Response.ErrorListener { error ->
                txtData.text = error.message
            })

           requestQ.add(stringRequest)

        }

        btnNext.setOnClickListener {

            val intent = Intent(this,ShowJsonObjectActivity::class.java)
            startActivity(intent)


        }

    }

}
