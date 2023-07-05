package com.example.androiddemoproject.webservices.imageupload

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class ImgBBViewModel(private val imageRepo: ImgBBRepository) : ViewModel() {
    val imageUploadState = MutableLiveData<UIState<Boolean>>(UIState.Initial())

    fun uploadImage(file: File) {
        viewModelScope.launch(Dispatchers.IO) {
            val imageUploaded = imageRepo.uploadImage(file)
            imageUploadState.postValue(if (imageUploaded) UIState.Success(true) else UIState.Error("Failed"))
        }
    }
}

class ImgBBViewModelFactory(private val imageRepo: ImgBBRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImgBBViewModel(imageRepo) as T
    }
}