package com.example.androiddemoproject.recyclerview.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddemoproject.databinding.ContactItemBinding

private val String.initials: String
    get() = this.first().toString()

class ContactListAdapter :
    ListAdapter<Contact, ContactListAdapter.ViewHolder>(ContactDiffUtils()) {
    inner class ViewHolder(val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            with(binding) {
                tvName.text = contact.name
                tvPhoneNumber.text = contact.phoneNumber
                tvInitial.text = contact.name.initials
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContactItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}