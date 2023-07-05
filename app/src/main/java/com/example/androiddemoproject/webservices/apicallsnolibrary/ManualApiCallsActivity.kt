package com.example.androiddemoproject.webservices.apicallsnolibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddemoproject.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL

class ManualApiCallsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_api_calls)
        CoroutineScope(Dispatchers.IO).launch {
            makeGetNetworkCall()
        }
    }

    private fun makeGetNetworkCall() {
        val string = URL("https://reqres.in/api/users?page=2").readText()
        println(string)
        val obj = JSONObject(string)
        val page = obj.getInt("page")
        println(page)
    }
}
