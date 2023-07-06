package com.example.androiddemoproject.webservices.apicallsnolibrary.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddemoproject.webservices.apicallsnolibrary.model.SquareUserLoginRequest
import com.example.androiddemoproject.webservices.apicallsnolibrary.model.SquareUserLoginResponse
import com.example.androiddemoproject.webservices.apicallsnolibrary.model.toJsonObject
import com.example.androiddemoproject.webservices.apicallsnolibrary.model.toSquareUserLoginResponseOrNull
import com.example.androiddemoproject.webservices.apicallsnolibrary.network.NetworkHelper
import com.example.androiddemoproject.webservices.apicallsnolibrary.network.ResponseState
import com.example.androiddemoproject.webservices.apicallsnolibrary.utils.tryOrNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class SquareLoginViewModel : ViewModel() {
    var credentials = SquareUserLoginRequest(email = "", password = "")
    var responseState =
        MutableLiveData<ResponseState<SquareUserLoginResponse>>(ResponseState.NotLoading)
        private set

    fun login() {
        Log.d("TAG", "login: $credentials")
        responseState.value = ResponseState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            callLoginApi()
        }
    }

    private suspend fun callLoginApi() {
        val cred = credentials.toJsonObject()
        val result = tryOrNull { NetworkHelper.requestPOST("https://reqres.in/api/login", cred) }

        withContext(Dispatchers.Main) {
            if (result.isNullOrEmpty()) {
                responseState.value = ResponseState.Error(Error("Something went wrong!"))
                return@withContext
            }
            val response = tryOrNull { JSONObject(result).toSquareUserLoginResponseOrNull() }
            responseState.value = if (response == null) {
                ResponseState.Error(Error("Invalid Response!"))
            } else {
                ResponseState.Success(response)
            }
        }
    }
}
