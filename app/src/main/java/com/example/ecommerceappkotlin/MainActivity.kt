package com.example.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedP : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGet.setOnClickListener {

            val serverURL : String = "http://192.168.43.186/PHPTest/test_file.php"
            var requestQ : RequestQueue = Volley.newRequestQueue(this@MainActivity)
            var stringRequest = StringRequest(Request.Method.GET, serverURL, Response.Listener { response ->
                txtData.text = response
            },Response.ErrorListener { error ->
                txtData.text = error.message
            })

            requestQ.add(stringRequest)

        }


    }
}
