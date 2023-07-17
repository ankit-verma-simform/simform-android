package com.example.androiddemoproject.permissions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityPermissionsDemoBinding

class PermissionsDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPermissionsDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_permissions_demo)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rvPermissions) {
            layoutManager = LinearLayoutManager(this@PermissionsDemoActivity)
            adapter = PermissionsAdapter(getPermissionsMainNavigation())
        }
    }
}