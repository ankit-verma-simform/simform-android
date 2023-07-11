package com.example.androiddemoproject.webservices.authretrofitrequests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentReqresUserListingBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel.ReqresUsersViewModel

class ReqresUserListingFragment : Fragment() {
    private lateinit var binding: FragmentReqresUserListingBinding
    private val viewModel by viewModels<ReqresUsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_reqres_user_listing, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
//        viewModel.passengerList.observe(viewLifecycleOwner) {
//            passengersAdapter.submitList(it)
//        }
    }

    private fun setupRecyclerView() {
//        binding.rvPassengers.apply {
//            adapter = passengersAdapter
//            layoutManager = LinearLayoutManager(context)
//        }
    }
}