package com.example.androiddemoproject.webservices.downloadfile

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityDownloadLargeFileBinding
import java.io.File

class DownloadLargeFileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadLargeFileBinding
    private val viewModel by viewModels<DownloadFileViewModel> {
        DownloadViewModelFactory(DownloadFileRepo(DownloadLargeFileService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_download_large_file)
        binding.btnDownloadLargeFile.setOnClickListener {
            val file = File(filesDir, "testFile")
            viewModel.downloadLargeFile(file)
        }
        setDownloadingObserver()
    }

    private fun setDownloadingObserver() {
        viewModel.fileSaved.observe(this) { state ->
            when (state) {
                DownloadState.NotStarted -> {}
                DownloadState.Started -> {
                    Toast.makeText(
                        this@DownloadLargeFileActivity,
                        "Downloading",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                DownloadState.Success -> {
                    Toast.makeText(
                        this@DownloadLargeFileActivity,
                        "Download Success",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                DownloadState.Failed -> {
                    Toast.makeText(
                        this@DownloadLargeFileActivity,
                        "Download Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}