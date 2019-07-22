package com.example.ecommerceappkotlin

import android.app.AlertDialog
import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class FetchEProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_eproducts)

        val selectedBrands : String = intent.getStringExtra("BRAND")

        var productsList = ArrayList<EProduct>()

        val productsURL = "http://192.168.43.183/OnlineStoreApp/fetch_eproducts.php?brand=$selectedBrands"

       val requestQ = Volley.newRequestQueue(this)

        val jsonAR = JsonArrayRequest(Request.Method.GET, productsURL, null, Response.Listener {
            response ->



            for (jsonObject in 0.until(response.length()))
            productsList.add(EProduct(response.getJSONObject(jsonObject).getInt("id"),
                response.getJSONObject(jsonObject).getString("name"),
                response.getJSONObject(jsonObject).getInt("price"),
                response.getJSONObject(jsonObject).getString("picture")))


        }, Response.ErrorListener { error ->
            val alertDialog = AlertDialog.Builder(this@FetchEProductsActivity)
            alertDialog.setTitle("Error").setMessage(error.message).create().show()
        })

        requestQ.add(jsonAR)

    }
}
