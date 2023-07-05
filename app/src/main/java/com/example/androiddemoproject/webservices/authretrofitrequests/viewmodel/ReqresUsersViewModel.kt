package com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUser
import com.example.androiddemoproject.webservices.authretrofitrequests.repository.ReqresUserRepository
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReqresUsersViewModel(private val userRepo: ReqresUserRepository) : ViewModel() {
    var usersState = MutableLiveData<UIState<List<ReqresUser>>>(UIState.Initial())
        private set
    var users = MutableLiveData(listOf<ReqresUser>())
        private set
    private var pageNo = 1
    private var totalPages = 1

    fun getUsers() {
        if (pageNo > totalPages) return
        usersState.value = UIState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userListResponse = userRepo.getUserList(page = pageNo, delay = 1)
                if (userListResponse.isSuccessful) {
                    val userList = userListResponse.body() ?: throw Error("Empty response body!")
                    val currentUsers = (users.value ?: listOf()) + userList.users
                    users.postValue(currentUsers)
                    usersState.postValue(UIState.Success(users.value))
                    pageNo++
                    totalPages = userList.totalPages
                    Log.d("TAG", "getUsers: $users")
                } else {
                    usersState.postValue(UIState.Error("Error: Response unsuccessful!"))
                }
            } catch (e: Exception) {
                Log.d("TAG", "getUsers: ${e.printStackTrace()}")
                usersState.postValue(UIState.Error("Error: ${e.message}"))
            }
        }
    }
}

class ReqresUsersViewModelFactory(private val userRepo: ReqresUserRepository) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ReqresUsersViewModel(userRepo) as T
    }
}
