package com.example.androiddemoproject.webservices.imageupload

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class ImgBBViewModel(private val imageRepo: ImgBBRepository) : ViewModel() {
    fun uploadImage(file: File) {
        viewModelScope.launch(Dispatchers.IO) {
            imageRepo.uploadImage(file)
        }
    }
}

class ImgBBViewModelFactory(private val imageRepo: ImgBBRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ImgBBViewModel(imageRepo) as T
    }
}