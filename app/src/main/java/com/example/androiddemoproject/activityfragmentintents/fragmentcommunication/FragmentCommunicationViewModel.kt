package com.example.androiddemoproject.activityfragmentintents.fragmentcommunication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentCommunicationViewModel : ViewModel() {
    private var _message = MutableLiveData("")
    val message: LiveData<String> get() = _message

    fun updateMessage(message: String) {
        _message.value = message
    }
}