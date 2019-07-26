package com.example.ecommerceappkotlin

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_finallize_shopping.*

class FinallizeShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finallize_shopping)

        var calculateTotalPriceUrl = "http://192.168.43.186/OnlineStoreApp/calculate_total_price.php?invoice_num=${intent.getStringExtra("LATEST_INVOICE_NUMBER")}"

        var requestQ = Volley.newRequestQueue(this@FinallizeShoppingActivity)
        var stringRequest = StringRequest(Request.Method.GET, calculateTotalPriceUrl, Response.Listener {
            response ->

            btnPayTotalPrice.text = "Pay $$response via Paypal Now!"

        }, Response.ErrorListener {
            error ->
            val alertDialog = AlertDialog.Builder(this@FinallizeShoppingActivity)
            alertDialog.setTitle(error.message).setMessage(error.message).create().show()
        })

    }
}
