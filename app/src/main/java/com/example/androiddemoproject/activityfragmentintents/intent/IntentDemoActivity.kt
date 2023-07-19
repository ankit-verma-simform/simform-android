package com.example.androiddemoproject.activityfragmentintents.intent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityIntentDemoBinding

class IntentDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentDemoBinding
    private val viewModel: IntentDemoViewModel by viewModels()

    companion object {
        const val REQUEST_CODE = 101
        const val NEW_QUERY = "NEW_QUERY"
        const val TAG = "IntentDemoActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent_demo)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setupBtnReturnWithNewQueryClickListener()
        pickPhotoFromGallerySetup()
    }

    private fun pickPhotoFromGallerySetup() {
        val photoContract = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            if (it != null) {
                Log.d(TAG, "onCreate: selected image $it")
                binding.imgBtnGalleryPhoto.setImageURI(it)
            } else {
                Log.d(TAG, "onCreate: no image selected")
            }
        }
        binding.imgBtnGalleryPhoto.setOnClickListener {
            photoContract.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }

    private fun setupBtnReturnWithNewQueryClickListener() {
        binding.btnReturnWithNewQuery.setOnClickListener {
            // just for exploring purpose
            @Suppress("DEPRECATION")
            startActivityForResult(
                Intent(this, ReturnWithResultDemoActivity::class.java),
                REQUEST_CODE
            )
        }
    }

    @Suppress("DEPRECATION")
    @Deprecated("Just for experimentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // just for exploring purpose
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult: called $requestCode, $resultCode $data")
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val newQuery = it.getStringExtra(NEW_QUERY).orEmpty()
                    Toast.makeText(this, newQuery, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "onActivityResult: ${binding.viewModel}")
                    Log.d(TAG, "onActivityResult: ${binding.viewModel?.searchQuery}")
                    binding.viewModel?.searchQuery?.value = newQuery
                    Log.d(TAG, "onActivityResult 444: ${viewModel.searchQuery}")
                }
            }
        }
    }
}