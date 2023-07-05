package com.example.androiddemoproject.webservices.authretrofitrequests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.FragmentReqresUserListingBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.adapter.ReqresUsersAdapter
import com.example.androiddemoproject.webservices.authretrofitrequests.network.ReqresApiService
import com.example.androiddemoproject.webservices.authretrofitrequests.repository.ReqresUserRepositoryImpl
import com.example.androiddemoproject.webservices.authretrofitrequests.utils.UIState
import com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel.ReqresUsersViewModel
import com.example.androiddemoproject.webservices.authretrofitrequests.viewmodel.ReqresUsersViewModelFactory

class ReqresUserListingFragment : Fragment() {
    private lateinit var binding: FragmentReqresUserListingBinding
    private val viewModel by viewModels<ReqresUsersViewModel> {
        ReqresUsersViewModelFactory(ReqresUserRepositoryImpl(ReqresApiService.api))
    }
    private val userAdapter by lazy { ReqresUsersAdapter() }

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
        viewModel.getUsers()
    }

    private fun setupObservers() {
        viewModel.usersState.observe(viewLifecycleOwner) { state ->
            binding.loadingIndicator.isGone = state !is UIState.Loading
        }
        viewModel.users.observe(viewLifecycleOwner) {
            userAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        binding.rvPassengers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
            addOnScrollListener(object : OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager !is LinearLayoutManager) {
                        return
                    }
                    val totalItemCount = layoutManager.itemCount
                    val lastVisible: Int = layoutManager.findLastVisibleItemPosition()
                    val endHasBeenReached = lastVisible >= totalItemCount - 1
                    if (totalItemCount > 0 && endHasBeenReached) {
                        viewModel.getUsers()
                    }
                }
            })
        }
    }
}