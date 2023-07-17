package com.example.androiddemoproject.permissions.camera

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityCameraDemoBinding
import java.io.File

class CameraDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraDemoBinding
    private var imageUri: Uri? = null

    private val contract = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            binding.imgFromCamera.setImageURI(imageUri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera_demo)
        imageUri = createImageUri()
        binding.btnPickPhotoFromCamera.setOnClickListener {
            contract.launch(imageUri)
        }
    }

    private fun createImageUri(): Uri? {
        val image = File(applicationContext.filesDir, "camera_photo.png")
        return FileProvider.getUriForFile(
            this,
            "com.example.androiddemoproject.fileProvider",
            image
        )
    }
}