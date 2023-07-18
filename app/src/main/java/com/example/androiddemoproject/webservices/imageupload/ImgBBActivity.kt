package com.example.androiddemoproject.webservices.imageupload

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityImgBbactivityBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import java.io.File
import java.io.FileOutputStream
import java.util.Date

class ImgBBActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImgBbactivityBinding
    private val viewModel by viewModels<ImgBBViewModel> {
        ImgBBViewModelFactory(ImgBBRepository(ImgBBApiService.instance))
    }
    private val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { imgUri ->
            imgUri?.let {
                val filesDir = applicationContext.filesDir
                val file = File(filesDir, Date().toString())

                val inputStream = contentResolver.openInputStream(it)
                val outputStream = FileOutputStream(file)
                inputStream?.copyTo(outputStream)

                Log.d("TAG", "uri: $it")
                viewModel.uploadImage(file)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_img_bbactivity)
        setupUploadButton()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.imageUploadState.observe(this) { state ->
            if (state is UIState.Success) {
                Toast.makeText(this, "Image saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupUploadButton() {
        binding.btnImageUpload.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }
}