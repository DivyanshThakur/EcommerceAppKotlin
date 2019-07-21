package com.example.ecommerceappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private var dialogBuilder: AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        dialogBuilder = AlertDialog.Builder(this)

        btnSignUpSA.setOnClickListener {

            if (edtSignUpPassword.text.toString().equals(edtSignUpConfirmPassword.text.toString())) {

                // Registration process

                val signUpURL = "http://192.168.43.186/OnlineStoreApp/index.php?email=" + edtSignUpEmail.text.toString() + "&username=" + edtSignUpUsername.text.toString() + "&pass=" + edtSignUpPassword.text.toString()

                val requestQ = Volley.newRequestQueue(this@SignUpActivity)

                val stringRequest = StringRequest(Request.Method.GET, signUpURL, Response.Listener { response ->

                    if (response.equals("A user with this Email Address already exist")) {
                        dialogBuilder!!.setTitle("Error").setMessage(response).create().show()
                    } else if (response.equals("Congratulations! The registration process was successful")) {

                        Toast.makeText(this@SignUpActivity, response, Toast.LENGTH_SHORT).show()
                        val homeIntent = Intent(this@SignUpActivity, HomeScreen::class.java)
                        startActivity(homeIntent)

                    } else {
                        dialogBuilder!!.setTitle("Error").setMessage(response).create().show()
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
