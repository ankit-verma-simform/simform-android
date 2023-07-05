package com.example.androiddemoproject.webservices.imageupload

import android.util.Log
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class ImgBBRepository(
    private val api: ImgBBApi
) {
    suspend fun uploadImage(file: File): Boolean {
        return try {
            val resp = api.uploadImage(
                key = "f98d8f3d2a5e8b449aa36471f06cb6a6",
                image = MultipartBody.Part
                    .createFormData("image", file.name, file.asRequestBody("image/*".toMediaTypeOrNull()))
            )
            Log.d("TAG", "uploadImage: $resp")
            resp.isSuccessful
        } catch (e: IOException) {
            e.printStackTrace()
            false
        } catch (e: HttpException) {
            e.printStackTrace()
            false
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}