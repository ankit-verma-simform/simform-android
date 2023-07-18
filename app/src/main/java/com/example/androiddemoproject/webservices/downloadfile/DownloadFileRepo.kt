package com.example.androiddemoproject.webservices.downloadfile

import android.util.Log
import okhttp3.ResponseBody
import java.io.File

class DownloadFileRepo(private val api: DownloadLargeFileService) {
    suspend fun downloadLargeFile(destinationFile: File): Boolean {
        val respBody = api.instance.downloadLargeFile()
        val isSuccess = respBody.saveFile(destinationFile)
        Log.d("TAG", "downloadLargeFile: $destinationFile")
        Log.d("TAG", "saved?: $isSuccess")
        return isSuccess
    }

    private fun ResponseBody.saveFile(destinationFile: File): Boolean {
        try{
            byteStream().use { inputStream ->
                destinationFile.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e: Exception) {
            return false
        }
        return true
    }
}
