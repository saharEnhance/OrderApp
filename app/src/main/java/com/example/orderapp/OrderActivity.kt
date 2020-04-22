package com.example.orderapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_order.*


class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val order: Order? = intent?.getParcelableExtra("person")
        clientTxt.text = order?.client.toString()
        dishTxt.text = order?.dish.toString()
    }
}
