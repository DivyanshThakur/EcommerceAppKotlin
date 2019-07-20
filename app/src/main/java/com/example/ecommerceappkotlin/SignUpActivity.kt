package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    var dialogBuilder: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        dialogBuilder = AlertDialog.Builder(this)

        btnSignUpSA.setOnClickListener {

            if (edtSignUpPassword.text.toString().equals(edtSignUpConfirmPassword.text.toString())) {

                // Registration process

                val signUpURL = "http://192.168.43.186/OnlineStoreApp/index.php?email=" + edtSignUpEmail.text.toString() + "&username=" + edtSignUpUsername.text.toString() + "&pass=" + edtSignUpPassword

                val requestQ = Volley.newRequestQueue(this)

                val stringRequest = StringRequest(Request.Method.GET, signUpURL, Response.Listener { response ->

                    if (response.equals("A user with this Email Address already exists")) {
                        dialogBuilder!!.setTitle("Error").setMessage(response).create().show()
                    } else {
                        dialogBuilder!!.setTitle("Success").setMessage(response).create().show()
                    }


                },Response.ErrorListener { error ->

                    dialogBuilder!!.setTitle("Error").setMessage(error.message).create().show()

                })

                requestQ.add(stringRequest)

            } else {

                dialogBuilder!!.setTitle("Alert").setMessage("Password Mismatch").create().show()
            }

        }

        btnLogInSA.setOnClickListener {
            finish()
        }

    }
}