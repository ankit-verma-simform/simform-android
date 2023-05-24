package com.example.androiddemoproject.uiwidgets.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.btnSignUp.setOnClickListener {
            val username = binding.username.editText?.text ?: "User"
            val action = SignUpFragmentDirections
                .actionSignUpFragmentToHomeFragment(userName = username.toString())
            findNavController().navigate(action)
        }
        binding.btnAlreadyHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        return binding.root
    }
}