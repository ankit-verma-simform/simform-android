package com.example.androiddemoproject.webservices.checknetworkavailability

import kotlinx.coroutines.flow.Flow

interface NetworkConnectivityObserver {
    fun isNetworkConnectionAvailable(): Boolean
    fun observe(): Flow<NetworkStatus>

    enum class NetworkStatus {
        Available, Unavailable, Losing, Lost
    }
}