package com.example.orderapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_person.*


class PersonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)
        val order: Order? = intent?.getParcelableExtra("person")
        nameTxt.text = order?.name.toString()
        ageTxt.text = order?.age.toString()
    }
}
