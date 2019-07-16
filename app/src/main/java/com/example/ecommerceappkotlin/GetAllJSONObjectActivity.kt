package com.example.ecommerceappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_get_all_jsonobject.*

class GetAllJSONObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_jsonobject)

        txtClick.setOnClickListener {

            val allProductURL = "http://192.168.43.186/Ecommerce/present_json_array.php"

            var allProducts =""

            val requestQ:RequestQueue = Volley.newRequestQueue(this@GetAllJSONObjectActivity)

            val jsonAR = JsonArrayRequest(Request.Method.GET,allProductURL,null, Response.Listener {  response ->

                for (productIndex in 0.until(response.length())) {
                    val pn = response.getJSONObject(productIndex).getString("name")
                    val pp = response.getJSONObject(productIndex).getInt("price")

                    allProducts += "$pn - $pp/n"
                }

                txtClick.text = allProducts

            }, Response.ErrorListener { error ->

                txtClick.text = error.message

            })

            requestQ.add(jsonAR)


        }

        button2.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
