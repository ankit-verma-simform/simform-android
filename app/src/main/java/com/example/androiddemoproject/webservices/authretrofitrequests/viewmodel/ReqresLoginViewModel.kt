package com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginError
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginRequest
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresLoginResponse
import com.example.androiddemoproject.webservices.authretrofitrequests.repository.ReqresAuthRepository
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReqresLoginViewModel(private val authRepo: ReqresAuthRepository) : ViewModel() {
    var loginCredential = MutableLiveData(ReqresLoginRequest(email = "eve.holt@reqres.in", password = "siliconvalley"))
    var loginState = MutableLiveData<UIState<ReqresLoginResponse>>(UIState.Initial())
        private set

    fun login() {
        val loginCredential = loginCredential.value ?: return
        loginState.value = UIState.Loading()

        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("TAG", "login: $loginCredential")
                val response = authRepo.login(loginCredential)

                if (response.isSuccessful) {
                    val resp = response.body()
                    if (resp == null) {
                        loginState.postValue(UIState.Error("Empty Response Body!"))
                        return@launch
                    }

                    loginState.postValue(UIState.Success(resp))
                    Log.d("TAG", "login: token ${response.body()?.token}")

                } else {
                    val resp = response.errorBody()?.string() ?: ""
                    val errorResponse = Gson().fromJson(resp, ReqresLoginError::class.java)
                    loginState.postValue(UIState.Error(errorResponse.error))
                }

            } catch (e: Exception) {
                Log.d("TAG", "login: ${e.printStackTrace()}")
                loginState.postValue(UIState.Error(e.message ?: "Error Occurred!"))
            }
        }
    }

    fun resetState() {
        loginState.value = UIState.Initial()
    }
}

class ReqresLoginViewModelFactory(private val authRepo: ReqresAuthRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ReqresLoginViewModel(authRepo) as T
    }
}
