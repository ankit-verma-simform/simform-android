package com.example.androiddemoproject.activityfragmentintents.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ActivityLifecycleDemoBinding

class ActivityLifecycleDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleDemoBinding

    companion object {
        const val TAG = "ActivityLifecycleDemoActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lifecycle_demo)
        Log.d(TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart:")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d(TAG, "onRestoreInstanceState:")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState:")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart:")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy:")
    }
}
