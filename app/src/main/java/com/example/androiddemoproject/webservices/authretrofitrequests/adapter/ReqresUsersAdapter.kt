package com.example.androiddemoproject.webservices.authretrofitrequests.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.R
import com.example.androiddemoproject.databinding.ReqresUserListItemBinding
import com.example.androiddemoproject.webservices.authretrofitrequests.model.ReqresUser

class ReqresUsersAdapter :
    ListAdapter<ReqresUser, ReqresUsersAdapter.ViewHolder>(TouristPassengerDiffUtil()) {
    inner class ViewHolder(val binding: ReqresUserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: ReqresUser) {
            binding.user = user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ReqresUserListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.reqres_user_list_item,
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TouristPassengerDiffUtil : DiffUtil.ItemCallback<ReqresUser>() {
        override fun areItemsTheSame(
            oldItem: ReqresUser,
            newItem: ReqresUser
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ReqresUser,
            newItem: ReqresUser
        ): Boolean {
            return oldItem == newItem
        }
    }
}
