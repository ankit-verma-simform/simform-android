package com.example.androiddemoproject.webservices.checknetworkavailability

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityConnectivityDemoBinding
import kotlinx.coroutines.launch

class ConnectivityDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConnectivityDemoBinding
    private val viewModel by viewModels<ConnectivityViewModel>(factoryProducer = {
        ConnectivityViewModelFactory(
            NetworkConnectivityObserverImpl(applicationContext)
        )
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_connectivity_demo)
        binding.connectivityStatus =
            if (viewModel.isNetworkAvailable) "Network Available" else "Network Unavailable"

        setObservers()
    }

    private fun setObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.connectivityState.collect {
                    Log.d("TAG", "onCreate: $it")
                    binding.connectivityStatus = "Network Connection: $it"
                }
            }
        }
    }
}