package com.example.androiddemoproject.webservices.okhttp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUser
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState

class OKHttpViewModel : ViewModel() {
    var usersState = MutableLiveData<UIState<List<ReqresUser>>>(UIState.Initial())
        private set

    var userAddedState = MutableLiveData<UIState<ReqresUser>>(UIState.Initial())
        private set

    fun getUsers() {
        usersState.value = UIState.Loading()
        OKHttpHelper.getUsers {
            if (it.successful && it.data != null) {
                usersState.postValue(UIState.Success(it.data.users))
            } else {
                usersState.postValue(UIState.Error(it.message.orEmpty()))
            }
        }
    }

    fun createUser() {
        OKHttpHelper.createUser(
            ReqresUser(
                "https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg",
                "eve.holland@gmail.co",
                "Eve",
                1,
                "Holland"
            )
        )  {
            Log.d("TAG", "createdUser: $it")
            userAddedState.postValue(UIState.Success(it.data))
        }
    }
}