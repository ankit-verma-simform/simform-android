package com.example.androiddemoproject.webservices.authretrofitrequests.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityRetrofitAuthDemoBinding

class RetrofitAuthDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRetrofitAuthDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_auth_demo)
    }
}