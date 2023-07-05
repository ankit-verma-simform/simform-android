package com.example.androiddemoproject.webservices.downloadfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class DownloadFileViewModel(private val downloadFileRepo: DownloadFileRepo) : ViewModel() {
    var fileSaved = MutableLiveData<DownloadState>(DownloadState.NotStarted)

    fun downloadLargeFile(destinationFile: File) {
        fileSaved.postValue(DownloadState.Started)
        viewModelScope.launch(Dispatchers.IO) {
            val isSuccess = downloadFileRepo.downloadLargeFile(destinationFile)
            fileSaved.postValue(if (isSuccess) DownloadState.Success else DownloadState.Failed)
        }
    }
}

class DownloadViewModelFactory(private val downloadFileRepo: DownloadFileRepo) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DownloadFileViewModel(downloadFileRepo) as T
    }
}