package com.example.androiddemoproject.webservices.checknetworkavailability

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow

class ConnectivityViewModel(connectivityObserver: NetworkConnectivityObserver) :
    ViewModel() {
    val connectivityState: Flow<NetworkConnectivityObserver.NetworkStatus> = connectivityObserver.observe()
    val isNetworkAvailable = connectivityObserver.isNetworkConnectionAvailable()
}

class ConnectivityViewModelFactory(private val connectivityObserver: NetworkConnectivityObserver) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConnectivityViewModel(connectivityObserver = connectivityObserver) as T
    }
}