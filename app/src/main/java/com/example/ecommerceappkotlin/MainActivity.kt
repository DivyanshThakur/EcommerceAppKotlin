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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dialogBuilder:AlertDialog.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogBuilder = AlertDialog.Builder(this@MainActivity)

        btnLogInLA.setOnClickListener {

             val logInURL = "http://192.168.43.186/OnlineStoreApp/login_app_user.php?email=" + edtLogInEmail.text.toString() +"&pass=" + edtLogInPassword.text.toString()
            val requestQ = Volley.newRequestQueue(this@MainActivity)
            val stringRequest = StringRequest(Request.Method.GET, logInURL, Response.Listener { response ->

                if (response.equals("The user does exist")) {

                    Person.email = edtLogInEmail.text.toString()

                    Toast.makeText(this, response, Toast.LENGTH_SHORT).show()

                    val homeIntent = Intent(this@MainActivity, HomeScreen::class.java)
                    startActivity(homeIntent)
                } else {
                    dialogBuilder!!.setTitle("Alert").setMessage(response).create().show()
                }

            }, Response.ErrorListener { error ->

                dialogBuilder!!.setTitle("Error").setMessage(error.message).create().show()

            })

            requestQ.add(stringRequest)

        }


        btnSignUpLA.setOnClickListener {

            var signUpIntent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(signUpIntent)

        }

    }

}
