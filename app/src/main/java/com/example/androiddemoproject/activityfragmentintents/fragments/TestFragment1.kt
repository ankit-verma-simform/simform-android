package com.example.androiddemoproject.activityfragmentintents.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentTest1Binding

class TestFragment1(private val fragmentNo: Int) : Fragment() {
    private lateinit var binding: FragmentTest1Binding

    companion object {
        const val TAG = "Test Fragment"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: $fragmentNo")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: $fragmentNo")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: $fragmentNo")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test1, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentTitle.text = fragmentNo.toString()
        Log.d(TAG, "onViewCreated: $fragmentNo")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: $fragmentNo")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $fragmentNo")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $fragmentNo")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: $fragmentNo")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: $fragmentNo")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $fragmentNo")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: $fragmentNo")
    }
}