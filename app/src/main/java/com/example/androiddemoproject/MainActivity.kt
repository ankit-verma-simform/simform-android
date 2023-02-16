package com.example.androiddemoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var txtWelcome: TextView
    lateinit var btnLetsGo: Button
    private var cnt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cnt = 0

        txtWelcome = findViewById(R.id.txtWelcome)
        btnLetsGo = findViewById(R.id.btnLetsGo)
        btnLetsGo.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        if (view != null) {
            if (view == btnLetsGo) {
                ++cnt
                val logText = getString(R.string.log_message)
                Log.d("DemoApp", logText)
                Toast.makeText(applicationContext, "Demo App", Toast.LENGTH_SHORT).show()
            }
        }
    }
}