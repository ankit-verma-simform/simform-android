package com.example.androiddemoproject.webservices.apicallsnolibrary.network

import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import javax.net.ssl.HttpsURLConnection

object NetworkHelper {
    private const val GET: String = "GET"
    private const val POST: String = "POST"

    @Throws(IOException::class)
    fun requestPOST(urlString: String?, postDataParams: JSONObject): ResponseState<String> {
        val url = URL(urlString)
        val conn: HttpURLConnection = (url.openConnection() as HttpURLConnection).apply {
            readTimeout = 3000
            connectTimeout = 3000
            requestMethod = POST
            doInput = true
            doOutput = true
        }

        try {
            val os: OutputStream = conn.outputStream
            val writer = BufferedWriter(OutputStreamWriter(os, "UTF-8"))
            writer.write(encodeParams(postDataParams))
            writer.flush()
            writer.close()
            os.close()
        } catch (e: Exception) {
            return ResponseState.Error(Error("Failed Connection!"))
        }

        return try {
            val reader = BufferedReader(InputStreamReader(conn.inputStream))
            val sb = StringBuffer("")
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                sb.append(line)
                break
            }
            reader.close()
            if (conn.responseCode == HttpsURLConnection.HTTP_OK) {
                ResponseState.Success(sb.toString())
            } else {
                ResponseState.Error(Error(sb.toString()))
            }
        } catch (e: Exception) {
            ResponseState.Error(Error("Invalid Response"))
        }
    }

    @Throws(IOException::class)
    fun requestGET(url: String?): String {
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection
        con.requestMethod = GET
        val responseCode = con.responseCode
        return if (responseCode == HttpURLConnection.HTTP_OK) { // connection ok
            val reader =
                BufferedReader(InputStreamReader(con.inputStream))
            var inputLine: String?
            val response = StringBuffer()
            while (reader.readLine().also { inputLine = it } != null) {
                response.append(inputLine)
            }
            reader.close()
            response.toString()
        } else {
            ""
        }
    }

    @Throws(IOException::class)
    private fun encodeParams(params: JSONObject): String {
        val result = StringBuilder()
        var first = true
        val itr = params.keys()
        while (itr.hasNext()) {
            val key = itr.next()
            val value = params[key]
            if (first) first = false else result.append("&")
            result.append(URLEncoder.encode(key, "UTF-8"))
            result.append("=")
            result.append(URLEncoder.encode(value.toString(), "UTF-8"))
        }
        return result.toString()
    }
}