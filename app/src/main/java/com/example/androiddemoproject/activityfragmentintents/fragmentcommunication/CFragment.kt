package com.example.androiddemoproject.activityfragmentintents.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentCBinding

class CFragment : Fragment() {
    private lateinit var binding: FragmentCBinding

    companion object {
        const val REQUEST_KEY = "messageFromCFragment"
        const val RESULT_KEY = "message"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_c, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSendMessageButtonListener()
    }

    private fun setupSendMessageButtonListener() {
        binding.btnSendMessage.setOnClickListener {
            parentFragmentManager.setFragmentResult(REQUEST_KEY, Bundle().apply {
                putString(RESULT_KEY, binding.etMessage.text.toString())
            })
        }
    }
}