package com.example.androiddemoproject.activityfragmentintents.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentDBinding

class DFragment : Fragment(), FragmentResultListener {
    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_d, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.setFragmentResultListener(CFragment.REQUEST_KEY, this, this)
    }

    override fun onFragmentResult(requestKey: String, result: Bundle) {
        when (requestKey) {
            CFragment.REQUEST_KEY -> {
                binding.tvMessage.text = result.getString(CFragment.RESULT_KEY, String())
            }
        }
    }
}