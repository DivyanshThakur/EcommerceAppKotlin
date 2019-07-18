package com.example.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rv.*

class RvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        var myProductsList = ArrayList<EProduct>()
        myProductsList.add(EProduct(0, "iPhone", 1000, R.drawable.iphone))
        myProductsList.add(EProduct(1, "iPad", 1500, R.drawable.ipad))
        myProductsList.add(EProduct(2, "iMac", 2000, R.drawable.imac))
        myProductsList.add(EProduct(3, "MacBook Pro", 3000, R.drawable.macbookpro))
        myProductsList.add(EProduct(4, "MacBook Air", 2000, R.drawable.macbookair))
        myProductsList.add(EProduct(5, "ps4", 1500, R.drawable.ps4))
        myProductsList.add(EProduct(6, "xBox Ones", 1000, R.drawable.xboxones))
        myProductsList.add(EProduct(7, "ps4 Pro", 2000, R.drawable.ps4pro))
        myProductsList.add(EProduct(8, "iPod Touch", 2500, R.drawable.ipodtouch))


        var rvAdapter = RVAdapter(this@RvActivity, myProductsList)
        recyclerView.layoutManager = LinearLayoutManager(this@RvActivity)
        recyclerView.adapter = rvAdapter

    }
}
