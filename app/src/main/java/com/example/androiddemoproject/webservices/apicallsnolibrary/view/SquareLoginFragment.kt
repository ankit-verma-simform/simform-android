package com.example.androiddemoproject.webservices.apicallsnolibrary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentSquareLoginBinding
import com.example.androiddemoproject.webservices.apicallsnolibrary.network.ResponseState
import com.example.androiddemoproject.webservices.apicallsnolibrary.viewmodel.SquareLoginViewModel


class SquareLoginFragment : Fragment() {
    private lateinit var binding: FragmentSquareLoginBinding
    private val viewModel by viewModels<SquareLoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_square_login,
            container, false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindOnLoginResponseState()
    }

    private fun bindOnLoginResponseState() {
        viewModel.responseState.observe(viewLifecycleOwner) {
            with(binding) {
                progressIndicator.isGone = it != ResponseState.Loading
                btnLogIn.isClickable = it != ResponseState.Loading

                when (it) {
                    is ResponseState.Error -> {
                        Toast.makeText(
                            context,
                            "Login failed! ${it.throwable.localizedMessage}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is ResponseState.Success -> {
                        Toast.makeText(
                            context,
                            "Login success! ${it.item.token}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {}
                }
            }
        }
    }
}
