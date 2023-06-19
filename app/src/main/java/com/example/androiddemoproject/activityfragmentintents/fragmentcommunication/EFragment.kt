package com.example.androiddemoproject.activityfragmentintents.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentEBinding

class EFragment(val viewModel: FragmentCommunicationViewModel) : Fragment() {
    private lateinit var binding: FragmentEBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_e, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSendMessageButtonListener()
    }

    private fun setupSendMessageButtonListener() {
        binding.btnSendMessage.setOnClickListener {
            viewModel.updateMessage(binding.etMessage.text.toString())
        }
    }
}