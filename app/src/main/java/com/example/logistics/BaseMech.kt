package com.example.logistics

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BaseMech : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_mech)
        val but = findViewById<Button>(R.id.button2)
        but.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}