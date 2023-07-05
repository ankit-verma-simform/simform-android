package com.example.androiddemoproject.webservices.retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddemoproject.webservices.retrofit.model.Todo
import com.example.androiddemoproject.webservices.retrofit.network.TodoApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class TodoRetrofitViewModel : ViewModel() {
    val todos = MutableLiveData(listOf<Todo>())
    val loading = MutableLiveData(false)

    fun getTodos() {
        loading.value = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = TodoApiService.instance.getTodos(userId = 3)
                if (response.isSuccessful && response.body() != null) {
                    withContext(Dispatchers.Main) {
                        loading.value = false
                        todos.value = response.body()
                    }
                    Log.d("TAG", "onCreate: success ${response.body()}!")
                } else {
                    Log.d("TAG", "onCreate: Failed request!")
                }
            } catch (e: IOException) {
                Log.d("TAG", "Check internet connection! ${e.message.toString()}")
            } catch (e: HttpException) {
                Log.d("TAG", e.message())
            } catch (e: Exception) {
                Log.d("TAG", "Something went wrong! ${e.message.toString()}")
            }
            withContext(Dispatchers.Main) {
                loading.value = false
            }
        }
    }
}