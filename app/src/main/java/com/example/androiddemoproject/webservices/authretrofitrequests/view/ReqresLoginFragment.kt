package com.example.androiddemoproject.webservices.authretrofitrequests.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentReqresLoginBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.network.ReqresApiService
import com.example.androiddemoproject.webservices.authretrofitrequests.repository.ReqresAuthRepositoryImpl
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.TokenManager
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel.ReqresLoginViewModel
import com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel.ReqresLoginViewModelFactory

class ReqresLoginFragment : Fragment() {
    private lateinit var binding: FragmentReqresLoginBinding
    private val viewModel by viewModels<ReqresLoginViewModel> {
        ReqresLoginViewModelFactory(ReqresAuthRepositoryImpl(ReqresApiService.api))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_reqres_login, container, false
        )
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    private fun setObservers() {
        viewModel.loginState.observe(viewLifecycleOwner) { state ->
            binding.loadingIndicator.isGone = state !is UIState.Loading
            binding.btnLogin.isEnabled = state !is UIState.Loading
            Log.d("TAG", "setObservers: $state")

            if (state is UIState.Success) {
                val token = state.data?.token ?: ""
                TokenManager.token = token
                val action = ReqresLoginFragmentDirections
                    .actionReqresLoginFragmentToReqresUserListingFragment(token)
                findNavController().navigate(action)
            }

            if (state is UIState.Error) {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}