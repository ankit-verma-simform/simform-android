package com.example.androiddemoproject.recyclerview.listadapter

import androidx.recyclerview.widget.DiffUtil

data class Contact(val id: Int, val name: String, val phoneNumber: String)

class ContactDiffUtils: DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}
