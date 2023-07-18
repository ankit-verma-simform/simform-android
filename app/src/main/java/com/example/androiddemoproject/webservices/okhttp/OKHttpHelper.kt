package com.example.androiddemoproject.webservices.okhttp

import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUser
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUserList
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.BasicApiResponse
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

object OKHttpHelper {
    private val client = OkHttpClient()
    private const val BASE_URL = "https://reqres.in/api/"

    fun createUser(user: ReqresUser, callback: (BasicApiResponse<ReqresUser>) -> Unit) {
        val path = "users"
        val userJson = Gson().toJson(user)
        val jsonObj = JSONObject(userJson)
        val mediaType = "application/json; charset=utf-8".toMediaType()
        val requestBody = jsonObj.toString().toRequestBody(mediaType)
        val request = Request.Builder()
            .url(BASE_URL + path)
            .post(requestBody)
            .build()
        val call = client.newCall(request)
        call.enqueue(ResponseHandler(ReqresUser::class.java) { callback(it) })
    }

    fun getUsers(callback: (BasicApiResponse<ReqresUserList>) -> Unit) {
        val path = "users"
        val request = Request.Builder()
            .url(BASE_URL + path)
            .get()
            .build()
        val call = client.newCall(request)
        call.enqueue(ResponseHandler(ReqresUserList::class.java) { callback(it) })
    }

    private class ResponseHandler<T>(
        val responseType: Class<T>,
        val callback: (BasicApiResponse<T>) -> Unit
    ) :
        Callback {
        override fun onFailure(call: Call, e: IOException) {
            callback(BasicApiResponse(e.message, false, null))
        }

        override fun onResponse(call: Call, response: Response) {
            val jsonResponse = response.body?.string()
            if (jsonResponse == null) {
                callback(
                    BasicApiResponse(
                        "Empty response",
                        false, null
                    )
                )
                return
            }

            try {
                val data = Gson().fromJson(jsonResponse, responseType)
                callback(BasicApiResponse(null, true, data))
            } catch (e: Exception) {
                callback(BasicApiResponse(e.message, true, null))
            }
        }
    }
}
